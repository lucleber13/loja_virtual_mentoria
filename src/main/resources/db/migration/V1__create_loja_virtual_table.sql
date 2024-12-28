CREATE SEQUENCE IF NOT EXISTS access_token_juno_api_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS accounts_payable_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS accounts_receivable_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS address_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS discount_coupon_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS image_product_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS invoice_product_item_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS juno_boleto_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS online_store_transaction_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS payment_methods_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS person_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS product_brand_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS product_category_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS product_reviews_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS product_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS purchase_invoice_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS role_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS sales_invoice_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS store_sale_item_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS tracking_status_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE access_token_juno_api
(
    id           BIGINT NOT NULL,
    access_token TEXT,
    CONSTRAINT pk_access_token_juno_api PRIMARY KEY (id)
);

CREATE TABLE accounts_payable
(
    id             BIGINT       NOT NULL,
    description    VARCHAR(255) NOT NULL,
    status         VARCHAR(255) NOT NULL,
    due_date       date         NOT NULL,
    payment_date   date,
    total_value    DECIMAL      NOT NULL,
    discount_value DECIMAL,
    person_id      BIGINT       NOT NULL,
    person_sup_id  BIGINT       NOT NULL,
    CONSTRAINT pk_accounts_payable PRIMARY KEY (id)
);

CREATE TABLE accounts_receivable
(
    id           BIGINT       NOT NULL,
    description  VARCHAR(255) NOT NULL,
    status       VARCHAR(255) NOT NULL,
    due_date     date         NOT NULL,
    payment_date date,
    total_value  DECIMAL      NOT NULL,
    person_id    BIGINT       NOT NULL,
    CONSTRAINT pk_accounts_receivable PRIMARY KEY (id)
);

CREATE TABLE address
(
    id           BIGINT       NOT NULL,
    street       VARCHAR(255) NOT NULL,
    number       VARCHAR(255) NOT NULL,
    complement   VARCHAR(255),
    neighborhood VARCHAR(255) NOT NULL,
    city         VARCHAR(255) NOT NULL,
    state        VARCHAR(255) NOT NULL,
    zip_code     VARCHAR(255) NOT NULL,
    person_id    BIGINT       NOT NULL,
    address_type VARCHAR(255) NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE business_person
(
    id                  BIGINT       NOT NULL,
    name                VARCHAR(255) NOT NULL,
    email               VARCHAR(255) NOT NULL,
    phone               VARCHAR(255) NOT NULL,
    cnpj                VARCHAR(255) NOT NULL,
    county_registration VARCHAR(255) NOT NULL,
    town_registration   VARCHAR(255),
    fantasy_name        VARCHAR(255) NOT NULL,
    company_name        VARCHAR(255) NOT NULL,
    category            VARCHAR(255),
    CONSTRAINT pk_business_person PRIMARY KEY (id)
);

CREATE TABLE discount_coupon
(
    id                  BIGINT       NOT NULL,
    code_discount       VARCHAR(255) NOT NULL,
    discount_value      DECIMAL,
    real_value_discount DECIMAL,
    expiration_date     date         NOT NULL,
    CONSTRAINT pk_discount_coupon PRIMARY KEY (id)
);

CREATE TABLE image_product
(
    id             BIGINT NOT NULL,
    original_image TEXT   NOT NULL,
    small_image    TEXT   NOT NULL,
    product_id     BIGINT NOT NULL,
    CONSTRAINT pk_image_product PRIMARY KEY (id)
);

CREATE TABLE invoice_product_item
(
    id                  BIGINT  NOT NULL,
    quantity            INTEGER NOT NULL,
    product_id          BIGINT  NOT NULL,
    purchase_invoice_id BIGINT  NOT NULL,
    CONSTRAINT pk_invoice_product_item PRIMARY KEY (id)
);

CREATE TABLE juno_boleto
(
    id BIGINT NOT NULL,
    CONSTRAINT pk_juno_boleto PRIMARY KEY (id)
);

CREATE TABLE online_store_transaction
(
    id                    BIGINT  NOT NULL,
    person_id             BIGINT  NOT NULL,
    delivery_address_id   BIGINT  NOT NULL,
    billing_address_id    BIGINT  NOT NULL,
    total_value           DECIMAL NOT NULL,
    discount_value        DECIMAL,
    payment_method_id     BIGINT  NOT NULL,
    sales_invoice_id      BIGINT,
    discount_coupon_id    BIGINT,
    delivery_fee          DECIMAL NOT NULL,
    delivery_time_in_days INTEGER NOT NULL,
    delivery_date         date    NOT NULL,
    sale_date             date    NOT NULL,
    CONSTRAINT pk_online_store_transaction PRIMARY KEY (id)
);

CREATE TABLE payment_methods
(
    id          BIGINT       NOT NULL,
    description VARCHAR(255) NOT NULL,
    CONSTRAINT pk_payment_methods PRIMARY KEY (id)
);

CREATE TABLE private_person
(
    id          BIGINT       NOT NULL,
    name        VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL,
    phone       VARCHAR(255) NOT NULL,
    cpf         VARCHAR(255) NOT NULL,
    birth_date  date,
    CONSTRAINT pk_private_person PRIMARY KEY (id)
);

CREATE TABLE product
(
    id                     BIGINT           NOT NULL,
    unity_type             VARCHAR(255)     NOT NULL,
    name                   VARCHAR(255)     NOT NULL,
    active                 BOOLEAN          NOT NULL,
    description            TEXT             NOT NULL,
    weight                 DOUBLE PRECISION NOT NULL,
    width                  DOUBLE PRECISION NOT NULL,
    height                 DOUBLE PRECISION NOT NULL,
    length                 DOUBLE PRECISION NOT NULL,
    sale_price             DECIMAL          NOT NULL,
    stock_quantity         INTEGER          NOT NULL,
    minimum_stock_quantity INTEGER,
    youtube_url            VARCHAR(255),
    alert_stock_quantity   BOOLEAN,
    click_count            INTEGER,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE product_brand
(
    id               BIGINT       NOT NULL,
    name_description VARCHAR(255) NOT NULL,
    CONSTRAINT pk_product_brand PRIMARY KEY (id)
);

CREATE TABLE product_category
(
    id               BIGINT       NOT NULL,
    name_description VARCHAR(255) NOT NULL,
    CONSTRAINT pk_product_category PRIMARY KEY (id)
);

CREATE TABLE product_reviews
(
    id         BIGINT       NOT NULL,
    rating     INTEGER      NOT NULL,
    review     VARCHAR(255) NOT NULL,
    product_id BIGINT       NOT NULL,
    person_id  BIGINT       NOT NULL,
    CONSTRAINT pk_product_reviews PRIMARY KEY (id)
);

CREATE TABLE purchase_invoice
(
    id                  BIGINT       NOT NULL,
    invoice_number      VARCHAR(255) NOT NULL,
    invoice_series      VARCHAR(255) NOT NULL,
    description         VARCHAR(255),
    total_value         DECIMAL      NOT NULL,
    value_discount      DECIMAL,
    value_icms          DECIMAL      NOT NULL,
    issue_date          date         NOT NULL,
    person_id           BIGINT       NOT NULL,
    accounts_payable_id BIGINT       NOT NULL,
    CONSTRAINT pk_purchase_invoice PRIMARY KEY (id)
);

CREATE TABLE role
(
    id   BIGINT       NOT NULL,
    role VARCHAR(255) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE sales_invoice
(
    id                          BIGINT       NOT NULL,
    invoice_number              VARCHAR(255) NOT NULL,
    series                      VARCHAR(255) NOT NULL,
    type                        VARCHAR(255) NOT NULL,
    xml                         TEXT         NOT NULL,
    pdf                         TEXT         NOT NULL,
    online_store_transaction_id BIGINT       NOT NULL,
    CONSTRAINT pk_sales_invoice PRIMARY KEY (id)
);

CREATE TABLE store_sale_item
(
    id                          BIGINT           NOT NULL,
    quantity                    DOUBLE PRECISION NOT NULL,
    product_id                  BIGINT           NOT NULL,
    online_store_transaction_id BIGINT           NOT NULL,
    CONSTRAINT pk_store_sale_item PRIMARY KEY (id)
);

CREATE TABLE tracking_status
(
    id                          BIGINT NOT NULL,
    distribution_center         VARCHAR(255),
    city                        VARCHAR(255),
    state                       VARCHAR(255),
    status                      VARCHAR(255),
    online_store_transaction_id BIGINT NOT NULL,
    CONSTRAINT pk_tracking_status PRIMARY KEY (id)
);

CREATE TABLE users
(
    id                   BIGINT       NOT NULL,
    email                VARCHAR(255) NOT NULL,
    password             VARCHAR(255) NOT NULL,
    actual_date_password date         NOT NULL,
    person_id            BIGINT       NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL
);

ALTER TABLE online_store_transaction
    ADD CONSTRAINT uc_online_store_transaction_sales_invoice UNIQUE (sales_invoice_id);

ALTER TABLE sales_invoice
    ADD CONSTRAINT uc_sales_invoice_online_store_transaction UNIQUE (online_store_transaction_id);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users_roles
    ADD CONSTRAINT unique_role_user UNIQUE (user_id, role_id);

ALTER TABLE purchase_invoice
    ADD CONSTRAINT ACCOUNTS_PAYABLE_FK FOREIGN KEY (accounts_payable_id) REFERENCES accounts_payable (id);

ALTER TABLE online_store_transaction
    ADD CONSTRAINT FK_BILLING_ADDRESS FOREIGN KEY (billing_address_id) REFERENCES address (id);

ALTER TABLE online_store_transaction
    ADD CONSTRAINT FK_DELIVERY_ADDRESS FOREIGN KEY (delivery_address_id) REFERENCES address (id);

ALTER TABLE online_store_transaction
    ADD CONSTRAINT FK_DISCOUNT_COUPON FOREIGN KEY (discount_coupon_id) REFERENCES discount_coupon (id);

ALTER TABLE tracking_status
    ADD CONSTRAINT FK_ONLINE_STORE_TRANSACTION FOREIGN KEY (online_store_transaction_id) REFERENCES online_store_transaction (id);

ALTER TABLE store_sale_item
    ADD CONSTRAINT FK_ONLINE_STORE_TRANSACTIONLAlCqF FOREIGN KEY (online_store_transaction_id) REFERENCES online_store_transaction (id);

ALTER TABLE online_store_transaction
    ADD CONSTRAINT FK_PAYMENT_METHOD FOREIGN KEY (payment_method_id) REFERENCES payment_methods (id);

ALTER TABLE product_reviews
    ADD CONSTRAINT FK_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE store_sale_item
    ADD CONSTRAINT FK_PRODUCTkoAVjC FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE online_store_transaction
    ADD CONSTRAINT FK_SALES_INVOICE FOREIGN KEY (sales_invoice_id) REFERENCES sales_invoice (id);

ALTER TABLE invoice_product_item
    ADD CONSTRAINT PRODUCT_FK FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE image_product
    ADD CONSTRAINT PRODUCT_FK1dxqQU FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE invoice_product_item
    ADD CONSTRAINT PURCHASE_INVOICE_FK FOREIGN KEY (purchase_invoice_id) REFERENCES purchase_invoice (id);

ALTER TABLE users_roles
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE users_roles
    ADD CONSTRAINT user_fk8tVb4Q FOREIGN KEY (role_id) REFERENCES role (id);