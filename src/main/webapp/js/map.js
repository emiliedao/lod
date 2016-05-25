/**
 * Created by emiliedao on 5/24/16.
 */
$(function () {
    // Instanciate the map
    $('#map').highcharts('Map', {
        chart : {
            borderWidth : 1,
            borderColor: "E7E7E7"
        },

        title : {
            text : 'Location in the world'
        },
        // subtitle : {
        //     text : ''
        // },

        legend: {
            enabled: false
        },

        series : [{
            name: 'Country',
            mapData: Highcharts.maps['custom/world'],
            data: countriesOccurrences,
            joinBy: ['iso-a2', 'code'],
            dataLabels: {
                enabled: true,
                color: '#FFFFFF',
                formatter: function () {
                    if (this.point.value) {
                        return this.point.name;
                    }
                }
            },
            tooltip: {
                headerFormat: '',
                pointFormat: '{point.name}'
            }
        }]
    });
});