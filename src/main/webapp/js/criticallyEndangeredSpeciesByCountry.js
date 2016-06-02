$(function () {
    $('#criticallyEndangeredSpeciesByCountry').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Number of critically endangered mammals by country'
        },
        xAxis: {
            type: 'category',
            labels: {
                rotation: -45,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Number of species'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: 'Critically endangered mammals: <b>{point.y:.1f}</b>'
        },
        series: [{
            name: 'Population',
            data: [

                ['Viet Nam', 9],

                ['Indonesia', 8],

                ['China', 6],

                ['India', 5],

                ['Cameroon', 4],
                ['Congo', 4],
                ['Lao People\'s Democratic Republic', 4],
                ['Papua New Guinea', 4],

                ['Angola', 3],
                ['Japan', 3],
                ['Malaysia', 3],
                ['Myanmar', 3],
                ['Nigeria', 3],
                ['South Africa', 3],
                ['Tanzania, United Republic of', 3]

                // ['Bangladesh', 2],
                // ['Botswana', 2],
                // ['Brunei Darussalam', 2],
                // ['Cambodia', 2],
                // ['Chad', 2],
                // ['Equatorial Guinea', 2],
                // ['Ethiopia', 2],
                // ['Kenya', 2],
                // ['Malawi', 2],
                // ['Mozambique', 2],
                // ['Mexico', 2],
                // ['Namibia', 2],
                // ['Philippines', 2],
                // ['Rwanda', 2],
                // ['Solomon Islands', 2],
                // ['Swaziland', 2],
                // ['Thailand', 2],
                // ['Zambia', 2],
                // ['Zimbabwe', 2],
                //
                // ['Austria', 1],
                // ['Belarus', 1],
                // ['Bhutan', 1],
                // ['Bulgaria', 1],
                // ['Central African Republic', 1],
                // ['Christmas Island', 1],
                // ['Croatia', 1],
                // ['Czech Republic', 1],
                // ['Estonia', 1],
                // ['Fiji', 1],
                // ['Finland', 1],
                // ['France', 1],
                // ['Gabon', 1],
                // ['Georgia', 1],
                // ['Germany', 1],
                // ['Hungary', 1],
                // ['Kazakhstan', 1],
                // ['Latvia', 1],
                // ['Lithuania', 1],
                // ['Mauritius', 1],
                // ['Moldova', 1],
                // ['Montenegro', 1],
                // ['Netherlands', 1],
                // ['Poland', 1],
                // ['Romania', 1],
                // ['Russian Federation', 1],
                // ['Serbia', 1],
                // ['Slovakia', 1],
                // ['Spain', 1],
                // ['Switzerland', 1],
                // ['Ukraine', 1],
                // ['United States', 1]

            ]

            ,
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                format: '{point.y:.1f}', // one decimal
                y: 10, // 10 pixels down from the top
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        }]
    });
});