﻿$(function () {

    /*$(document).ajaxStart(function () {
        console.log("Loading users...");
    });
    $(document).ajaxStop(function () {
        console.log("Users loaded.");
    });*/

    $(document).ready(function () {
        $('#loadUsers').click(function () {
            $.ajax({
                url: '/user/indexasync',
                dataType: 'html',
                success: function (data) {
                    $('#target').html(data);
                }
            });
        });
        $('#loadComplexUsers').click(function () {
            $.ajax({
                url: '/user/complexindexasync',
                dataType: 'html',
                success: function (data) {
                    $('#target').html(data);
                }
            });
        });
        $('#loadUsersAsyncCtrl').click(function () {
            $.ajax({
                url: '/userasync/index',
                dataType: 'html',
                success: function (data) {
                    $('#target').html(data);
                }
            });
        });
    });

});