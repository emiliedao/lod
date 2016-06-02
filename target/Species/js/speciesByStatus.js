/**
 * Created by emiliedao on 5/25/16.
 */
$(function () {
    $('#speciesByStatus').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Species by conservation status'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: 'Proportion',
            colorByPoint: true,
            data: [{
                name: 'Critically endangered',
                y: 6.0,
                color: 'rgb(255,116,116)'
            }, {
                name: 'Data deficient',
                y: 4.0,
                color: '#434348'
            }, {
                name: 'Endangered',
                y: 12.0,
                color: 'rgb(255,117,153)'
            }, {
                name: 'Exctinct in the wild',
                y: 0.0,
                color: '#e7e7e7'
            }, {
                name: 'Extinct',
                y: 2.0,
                color: '#8085e9'
            }, {
                name: 'Least concern',
                y: 43.0,
                color: '#90ed7d'
            }, {
                name: 'Not evaluated',
                y: 0.0,
                color: '#e7e7e7'
            }, {
                name: 'Near threatened',
                y: 6.0,
                color: '#e4d354'
            }, {
                name: 'Vulnerable',
                y: 12.0,
                color: '#f7a35c'
            }]

        }]
    });
});