$(function () {
    $('#container').highcharts({
        title: {
            text: 'Historical assessment',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: IUCN Red List',
            x: -20
        },
        xAxis: {
            title: {
                text: 'Year'
            },
            allowDecimals: false,
            labels: {
                formatter: function () {
                    return this.value + 1950; // clean, unformatted number for year
                }
            }
        },
        yAxis: {
            title: {
                text: 'Conservation Status'
            },
            allowDecimals: false,
            categories: ['Not evaluated', 'Data deficient', 'Extinct in the wild', 'Least concern', 'Near threatened', 'Vulnerable', 'Endangered', 'Critically endangered'],
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },

        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Tokyo',
            data: [1,2,3,2,0,0,0,0,0,6]
        }]
    });
});