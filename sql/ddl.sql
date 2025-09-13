CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA restaurant;
CREATE SCHEMA consumption;

CREATE TABLE restaurant.restaurant (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100) UNIQUE NOT NULL,
    hotel_id UUID,
    address TEXT,
    phone VARCHAR(20) NOT NULL,
    capacity INTEGER,
    opening_time TIME,
    closing_time TIME,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE restaurant.food_dishes (
    id UUID PRIMARY KEY,
    restaurant_id UUID NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price NUMERIC(10,2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_food_dishes_rest FOREIGN KEY (restaurant_id) REFERENCES restaurant.restaurant(id)
);

ALTER TABLE restaurant.food_dishes
    ADD COLUMN cost NUMERIC(10,2) DEFAULT 0.00;

ALTER TABLE restaurant.food_dishes
    ALTER COLUMN cost SET NOT NULL;

-- CONSUMPTIONS (pedidos y detalles) dentro del mismo servicio
CREATE TABLE consumption.order (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    restaurant_id UUID NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_price NUMERIC(10,2) NOT NULL,
    discount_percentage NUMERIC(5,2),
    promotion_id UUID,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_orders_rest FOREIGN KEY (restaurant_id) REFERENCES restaurant.restaurant(id)
);

CREATE TABLE consumption.order_detail (
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    dish_id UUID NOT NULL,
    quantity INTEGER NOT NULL,
    unit_price NUMERIC(10,2) NOT NULL,
    unit_cost NUMERIC(10,2) NOT NULL,
    subtotal NUMERIC(10,2),
    discount_percentage NUMERIC(5,2),
    promotion_id UUID,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_od_order_details FOREIGN KEY (order_id) REFERENCES consumption.order(id),
    CONSTRAINT fk_dish FOREIGN KEY (dish_id) REFERENCES restaurant.food_dishes(id)
);