ALTER TABLE users_roles
DROP
CONSTRAINT role_fk;

ALTER TABLE users_roles
DROP
CONSTRAINT user_fk;

ALTER TABLE private_person
    ADD person_type VARCHAR(255);

DROP TABLE users_roles CASCADE;

DROP SEQUENCE access_token_juno_api_seq CASCADE;

DROP SEQUENCE accounts_payable_seq CASCADE;

DROP SEQUENCE accounts_receivable_seq CASCADE;

DROP SEQUENCE address_seq CASCADE;

DROP SEQUENCE discount_coupon_seq CASCADE;

DROP SEQUENCE image_product_seq CASCADE;

DROP SEQUENCE invoice_product_item_seq CASCADE;

DROP SEQUENCE juno_boleto_seq CASCADE;

DROP SEQUENCE online_store_transaction_seq CASCADE;

DROP SEQUENCE payment_methods_seq CASCADE;

DROP SEQUENCE product_brand_seq CASCADE;

DROP SEQUENCE product_category_id_seq CASCADE;

DROP SEQUENCE product_reviews_seq CASCADE;

DROP SEQUENCE product_seq CASCADE;

DROP SEQUENCE purchase_invoice_seq CASCADE;

DROP SEQUENCE role_seq CASCADE;

DROP SEQUENCE sales_invoice_seq CASCADE;

DROP SEQUENCE store_sale_item_seq CASCADE;

DROP SEQUENCE tracking_status_seq CASCADE;

DROP SEQUENCE user_seq CASCADE;