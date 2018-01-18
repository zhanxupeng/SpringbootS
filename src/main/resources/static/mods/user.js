/**

 @Name: 用户模块

 */

layui.define(['laypage', 'fly', 'element', 'flow'], function (exports) {

    var $ = layui.jquery;
    var layer = layui.layer;
    var util = layui.util;
    var laytpl = layui.laytpl;
    var form = layui.form;
    var laypage = layui.laypage;
    var fly = layui.fly;
    var flow = layui.flow;
    var element = layui.element;
    var upload = layui.upload;

    //显示当前tab
    if (location.hash) {
        element.tabChange('user', location.hash.replace(/^#/, ''));
    }

    element.on('tab(user)', function () {
        var othis = $(this), layid = othis.attr('lay-id');
        if (layid) {
            location.hash = layid;
        }
    });

    //根据ip获取城市
    if ($('#L_city').val() === '') {
        $.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js', function () {
            $('#L_city').val(remote_ip_info.city || '');
        });
    }

    //上传图片
    if ($('.upload-img')[0]) {
        layui.use('upload', function (upload) {
            var avatarAdd = $('.avatar-add');

            upload.render({
                elem: '.upload-img'
                , url: '/image/upload/'
                , size: 500
                , before: function () {
                    avatarAdd.find('.loading').show();
                }
                , done: function (res) {
                    if (res.status == 0) {
                        $.post('/customer/modifyHead/', {
                            headPicture: res.url
                        }, function (res) {
                            location.reload();
                        });
                    } else {
                        layer.msg(res.msg, {icon: 5});
                    }
                    avatarAdd.find('.loading').hide();
                }
                , error: function () {
                    avatarAdd.find('.loading').hide();
                }
            });
        });
    }

    exports('user', null);

});