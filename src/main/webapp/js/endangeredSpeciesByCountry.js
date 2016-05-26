$(function () {
    $('#endangeredSpeciesByCountry').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Number of endangered mammals by country'
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
            pointFormat: 'Endangered mammals: <b>{point.y:.1f}</b>'
        },
        series: [{
            name: 'Population',
            data: [
                ['Indonesia', 24],
                ['India', 13],
                ['Viet Nam', 11],
                ['China', 10],
                ['Lao People\'s Democratic Republic', 10],
                ['Malaysia', 10],
                ['Thailand', 10],
                ['Cambodia', 8],
                ['Japan', 8],
                ['Myanmar', 7],
                ['Mexico', 6],
                ['Solomon Islands', 5],
                ['United States', 5],
                ['Bangladesh', 4],
                ['Bhutan', 4],
                ['Brunei Darussalam', 4],
                ['Nepal', 4],
                ['Russian Federation', 4],
                ['Tanzania, United Republic of', 4],
                // ['Argentina', 3],
                // ['Chile', 3],
                // ['Cameroon', 3],
                // ['Congo, The Democratic Republic of the', 3],
                // ['Nigeria', 3],
                // ['Peru', 3],
                // ['Sri Lanka', 3]
                // ['Afghanistan', 2],
                // ['Bolivia, Plurinational States of', 2],
                // ['Canada', 2],
                // ['Côte d\'Ivoire', 2],
                // ['Ecuador', 2],
                // ['Equatorial Guinea', 2],
                // ['Ethiopia', 2],
                // ['Gambia', 2],
                // ['Ghana', 2],
                // ['Guinea-Bissau', 2],
                // ['Kazakhstan', 2],
                // ['Kenya', 2],
                // ['Kyrgyzstan', 2],
                // ['Papua New Guinea', 2],
                // ['Mongolia', 2],
                // ['Pakistan', 2],
                // ['Philippines', 2],
                // ['Portugal', 2],
                // ['Rwanda', 2],
                // ['Senegal', 2],
                // ['Sierra Leone', 2],
                // ['Tajikistan', 2],
                // ['Uganda', 2],
                // ['Uzbekistan', 2],
                // ['Algeria', 1],
                // ['Andorra', 1],
                // ['Angola', 1],
                // ['Austria', 1],
                // ['Belarus', 1],
                // ['Belgium', 1],
                // ['Benin', 1],
                // ['Bosnia and Herzegovina', 1],
                // ['Botswana', 1],
                // ['Brazil', 1],
                // ['Burkina Faso', 1],
                // ['Burundi', 1],
                // ['Central African Republic', 1],
                // ['Chad', 1],
                // ['Colombia', 1],
                // ['Croatia', 1],
                // ['Comoros', 1],
                // ['Czech Republic', 1],
                // ['Eritrea', 1],
                // ['Estonia', 1],
                // ['Egypt', 1],
                // ['Finland', 1],
                // ['France', 1],
                // ['French Guiana', 1],
                // ['Gabon', 1],
                // ['Germany', 1],
                // ['Gibraltar', 1],
                // ['Guam', 1],
                // ['Guinea', 1],
                // ['Guyana', 1],
                // ['Italy', 1],
                // ['Korea, Republic of', 1],
                // ['Latvia', 1],
                // ['Liberia', 1],
                // ['Lithuania', 1],
                // ['Luxembourg', 1],
                // ['Mali', 1],
                // ['Madagascar', 1],
                // ['Malawi', 1],
                // ['Mauritania', 1],
                // ['Micronesia, Federated States of ', 1],
                // ['Moldova', 1],
                // ['Morocco', 1],
                // ['Mozambique', 1],
                // ['Namibia', 1],
                // ['Netherlands', 1],
                // ['Niger', 1],
                // ['Northern Mariana Islands', 1],
                // ['Paraguay', 1],
                // ['Poland', 1],
                // ['Romania', 1],
                // ['Singapore', 1],
                // ['Slovakia', 1],
                // ['Slovenia', 1],
                // ['Spain', 1],
                // ['South Africa', 1],
                // ['South Sudan', 1],
                // ['Sudan', 1],
                // ['Suriname', 1],
                // ['Swaziland', 1],
                // ['Switzerland', 1],
                // ['Togo', 1],
                // ['Tunisia', 1],
                // ['Ukraine', 1],
                // ['Venezuela, Bolivarian Republic of', 1],
                // ['Zambia', 1],
                // ['Zimbabwe', 1]

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
});/**
 * Created by emiliedao on 5/26/16.
 */
