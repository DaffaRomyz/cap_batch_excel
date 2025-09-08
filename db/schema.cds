namespace db;

@cds.persistence.skip
entity Upload @odata.singleton {
    Products : LargeBinary @Core.MediaType: 'application/vnd.ms-excel';
}

entity Products {
    key Id : UUID;
    Title : String;
    Descr : String;
    Stock : Integer;
    Price : Decimal(9, 2);
}