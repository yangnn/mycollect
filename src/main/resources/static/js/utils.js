(function ($) {
    var Obj = function () {

    };
    Obj.DEFAULT = {
        type: "get",
        contentType: 'application/json'
    }

    Obj.prototype.process = function (btn) {
        $(btn).after("<button disabled processing class='btn btn-default'>处理中...</button>");
        $(btn).hide();
    }
    Obj.prototype.cancelProcess = function (btn) {
        $(btn).nextAll("[processing]").remove();
        $(btn).show();
    }
    Obj.prototype.getParam = function (key) {
        if (key) {
            key = "_Parameter" + "_" + key;
        } else {
            key = "_Parameter";
        }
        var data = window.sessionStorage.getItem(key)
        if (data) {
            return JSON.parse(data);
        }
    }
    Obj.prototype.setParam = function (data, key) {
        if (key) {
            key = "_Parameter" + "_" + key;
        } else {
            key = "_Parameter";
        }
        window.sessionStorage.setItem(key, JSON.stringify(data))
    }
    Obj.prototype.goPage = function (page, data, key) {
        this.setParam(data, key);
        window.location.hash = "#" + page;
    }
    Obj.prototype._ajax = function (options) {
        if (options.url.indexOf("http") < 0 && this.baseUrl) {
            //options.url = this.baseUrl + "/questionlib/" + options.url;
            options.url = this.baseUrl + "" + options.url;
        }
        var req = $.extend({}, Obj.DEFAULT, options);
        req.success = function (data) {
            if (data && data.code === 30001) {//未登录拦截
                var url = "/login.html";
                var ssoSwitch   = data.data.ssoSwitch;
                if(ssoSwitch === true){
                    var ssoLoginUrl = data.data.ssoLoginUrl;
                    var redirectUrl = data.data.redirectUrl;
                    url = ssoLoginUrl + "?" + redirectUrl + "&questionLibrary";
                }
                window.location.href = url;
                return;
            }
            if (options.success && typeof options.success == "function") {
                if (data.success && data.data && data.data.records && window.coders) {
                    var records = data.data.records;
                    convertCode(records);
                } else if (data.success === false) {
                    var errorMessage = data.message;
                    if (errorMessage == null || errorMessage == undefined || errorMessage.length == 0) {
                        errorMessage = "网络异常，请稍后重试";
                    }
                    $.alert({
                        title: '错误',
                        content: errorMessage
                    });
                }
                options.success(data);
            }
        }
        req.error = function (ex) {
            if (options.error && typeof options.error == "function") {
                options.error(ex);
            } else {
                console.log(ex);
            }
        }


        if (req.type.toLowerCase() != "get".toLowerCase()) {
            req.data = JSON.stringify(req.data);
        }

        req.async = true;//默认异步
        if(options.async !== undefined){
            req.async = options.async;
        }

        if (!options || options.ignoreCodes || window.codersCompleted) {
             $.ajax(req);
        } else {
            $.when(window.$codersDeferred).then(function (d) {
                 $.ajax(req);
            });
        }

    }

    Obj.prototype.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        //if (r != null) return unescape(r[2]); return null; //返回参数值
        if (r != null) return decodeURIComponent(r[2]); return null; //返回参数值
    }

    Obj.prototype.encodeHtmlByRegExp = function (str) {
        var s = "";
        str = str + "";
        if(str.length == 0) return "";
        s = str.replace(/&/g,"&amp;");
        s = s.replace(/</g,"&lt;");
        s = s.replace(/>/g,"&gt;");
        s = s.replace(/ /g,"&nbsp;");
        s = s.replace(/\'/g,"&#39;");
        s = s.replace(/\"/g,"&quot;");
        return s;
    }

    function convertCode(records) {
        if (records instanceof Array) {
            $.each(records, function (m, n) {
                if (n instanceof Array) {
                    convertCode(n);
                } else if (n instanceof Object) {
                    convertCodeObj(n);
                }
            });
        } else if (records instanceof Object) {
            convertCodeObj(n);
        }

    }

    function convertCodeObj(n) {
        for (var k in n) {
            if (n[k] instanceof Array) {
                convertCode(n[k]);
            } else if (n[k] instanceof Object) {
                convertCodeObj(n[k]);
            } else if (k.lastIndexOf("Code") >= 0) {
                var m = k.substring(0, 1).toUpperCase() + k.substring(1, k.length + 1);
                var list = window.coders[m];
                if (list) {
                    $.each(list, function (a, b) {
                        if (b.id == n[k]) {
                            n[k + "Name"] = b.text;
                            return false;
                        }
                    });
                }
            } else if (k.lastIndexOf("Id") >= 0) {
                var m = k.substring(0, k.lastIndexOf("Id"));
                var list = window.serverCoders[m];
                if (list) {
                    $.each(list, function (a, b) {
                        if (b.id == n[k]) {
                            n[k + "Name"] = b.text;
                            return false;
                        }
                    });
                }
            }
        }
    }

    window._util = new Obj();

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };


})(jQuery)