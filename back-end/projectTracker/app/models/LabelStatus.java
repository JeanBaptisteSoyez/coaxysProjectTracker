package models;

/**
 * Created by formation04 on 30/03/17.
 */
public enum LabelStatus {

    OK,KO_BUG,KO_IMPROPER;

}
/*
GET    /api/products                                api.ApiProduct.products(format: 'json')
GET    /api/products.{format}                       api.ApiProduct.products

GET    /api/product/{id}                            api.ApiProduct.product
DELETE /api/product/{id}                            api.ApiProduct.deleteProduct

POST   /api/client/signup                           api.ApiClient.signUp


POST    /cart/add                                     Panier.addToCart
GET     /cart                                         Panier.showCart
GET     /cart/{id}/quantity/{quantity}                Panier.changeQuantity

GET     /admin                                        Admin.index
GET     /admin/produits                               Produits.products
GET     /admin/produit/{id}/edit                      Produits.editProduct
GET     /admin/produit/new                            Produits.editProduct
POST    /admin/produit/save                           Produits.saveProduct


GET     /admin/clients                                Clients.clients
GET     /admin/client/new                             Clients.editClient
GET     /admin/client/{id}/edit                       Clients.editClient

POST    /admin/client/save                            Clients.saveClient
*/