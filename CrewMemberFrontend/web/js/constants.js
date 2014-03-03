angular.module('myApp.constants', []).constant('WEEK_DAYS', [{name: "Segunda-feira", shortName: "SEG", value: 1},
    {name: "Terça-feira", shortName: "TER", value: 2},
    {name: "Quarta-feira", shortName: "QUA", value: 4},
    {name: "Quinta-feira", shortName: "QUI", value: 8},
    {name: "Sexta-feira", shortName: "SEX", value: 16},
    {name: "Sábado", shortName: "SÁB", value: 32},
    {name: "Domingo", shortName: "DOM", value: 64}])
        .constant('EXTENDED_WEEK_DAYS', [{name: "Útil", shortName: "ÚTIL", value: 31}, {name: "Segunda-feira", shortName: "SEG", value: 1},
            {name: "Terça-feira", shortName: "TER", value: 2},
            {name: "Quarta-feira", shortName: "QUA", value: 4},
            {name: "Quinta-feira", shortName: "QUI", value: 8},
            {name: "Sexta-feira", shortName: "SEX", value: 16},
            {name: "Sábado", shortName: "SÁB", value: 32},
            {name: "Domingo", shortName: "DOM", value: 64}]);