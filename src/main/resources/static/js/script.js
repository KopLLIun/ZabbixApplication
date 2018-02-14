$('document').ready(function () {

    function convertUnixTime(unixtimestamp){
        // Months array
        var months_arr = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
        // Convert timestamp to milliseconds
        var date = new Date(unixtimestamp*1000);
        // Year
        var year = date.getFullYear();
        // Month
        var month = months_arr[date.getMonth()];
        // Day
        var day = date.getDate();
        // Hours
        var hours = date.getHours();
        // Minutes
        var minutes = "0" + date.getMinutes();
        // Seconds
        var seconds = "0" + date.getSeconds();
        // Display date time in MM-dd-yyyy h:m:s format
        var convDataTime = month+'-'+day+'-'+year+' '+hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);

        return convDataTime;
    }

    $('#hosts').on('change', function () {
        var host_id = $(this).val();
        if (host_id === '0') {
            $('#items').html('<option>- Выберите узел -</option>');
            $('#items').attr('disabled', true);
            return(false);
        }
        $('#items').attr('disabled', true);
        $('#items').html('<option>загрузка...</option>');

        var url = '/devices';
        //var url = /js/items.json
        //var url = '/devices?' + 'items_id=' + item_id;
        //$(location).attr('href', url);
        $.get(url,
            "host_id=" + host_id,
            function (data) {
                if (data.type === 'error') {
                    alert('error');
                    return(false);
                }
                else {
                    console.log(data);
                    $("#items :first").remove();
                    //var options = '';
                    $.each(data, function(key, value) {
                        $('#items')
                            .append($("<option></option>")
                                .attr("value",value.itemid)
                                .text(value.name));
                        //options += '<option value="' + $(this).attr("hostid") + '">' + $(this).attr(value.name) + '</option>';
                        //console.log(data);
                        //console.log(value.hostid);
                        //options += '<option value="' + $(this).attr('id') + '">' + $(this).attr('title') + '</option>';
                    });
                    //$('#items').html(options);
                    $('#items').attr('disabled', false);
                }
            },
            "json"
        );
    });

/*    $('#items').on('change', function ()  {
        var item_id = $(this).val();
        var url = '/history?item_id=' + item_id;
        $(location).attr('href', url);
    });*/
    $('#items').on('change', function ()  {
        var item_id = $(this).val();
        var url = '/history';
        $.get(url,
            "item_id=" + item_id,
            function (data) {
                if (data.type === 'error') {
                    alert('error');
                    return(false);
                }
                else {
                    console.log(data);
                    //var history = '';
                    var history ='<caption>Последние значения</caption>\n' +
                        '<tr>\n' +
                        '<th>Время</th>\n' +
                        '<th>Значение</th>\n' +
                        '</tr>';
                    $.each(data, function(key, value) {
                        history += '<tr>';
                        history += '<td>' + convertUnixTime(value.clock) + '</td>';
                        history += '<td>' + value.value + '</td>';
                        history += '</tr>';
                    });
                    //alert(data);
                    $('#history').html(history);
                }
            },
            "json"
        );
    });
});

/*
jQuery('document').ready(function () {
    $('#hosts').on('change', function(){
        $('#hosts option').each(function () {
            $('#result').html(this.text);
        })
        //$('#items').html($('select option:selected').text());
    })
    /!*    var array_option = new Array();
    $('#city option').each(function () {
        array_option.push(this.text);
    });
    if ($('#city option :selected')) {
        //$('div#result').html($('#city option:selected').text());
        //$('#items').prepend('<option value="0">Добавить в самое начала Select</option>');
        $("#city :selected").val();
    }*!/
    //alert(array_option[3]);
    /!*for(var i=1; i < array_option.length; i++) {
        if ($(array_option[i])) {
            alert('Hi');
        }
    }*!/
    //$('div#result').html(array_option);
});*/
