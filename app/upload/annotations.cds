using AdminService as service from '../../srv/service';
annotate service.Products with @(
    UI.LineItem : [
        {
            $Type : 'UI.DataField',
            Value : Id,
            Label : 'Id',
        },
        {
            $Type : 'UI.DataField',
            Value : Title,
            Label : 'Title',
        },
        {
            $Type : 'UI.DataField',
            Value : Descr,
            Label : 'Descr',
        },
    ],
    UI.SelectionFields : [
        Id,
        Title,
        Descr,
    ],
);

annotate service.Products with {
    Id @Common.Label : 'Id'
};

annotate service.Products with {
    Title @Common.Label : 'Title'
};

annotate service.Products with {
    Descr @Common.Label : 'Descr'
};

