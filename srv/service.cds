using { db } from '../db/schema';

service AdminService {

    entity Upload as projection on db.Upload;

    entity Products as projection on db.Products;
}