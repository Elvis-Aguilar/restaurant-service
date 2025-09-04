----------------------------------------------------------------------
-- Insertar datos en la tabla restaurant.restaurant
----------------------------------------------------------------------

insert into restaurant.restaurant(name, hotel_id, address, phone, capacity, opening_time, closing_time)
VALUES('Sabor Picante', null, 'Zona 15 Ciudad Guatemala', '45866996', 30, '08:00','22:00' );

INSERT INTO restaurant.restaurant(name, hotel_id, address, phone, capacity, opening_time, closing_time)
VALUES('La Parrilla de Oro', null, 'Zona 10 Ciudad Guatemala', '55589977', 50, '11:00','23:00');

INSERT INTO restaurant.restaurant(name, hotel_id, address, phone, capacity, opening_time, closing_time)
VALUES('Mar y Tierra', null, 'Puerto San José, Escuintla', '44228899', 35, '10:00','21:00');

INSERT INTO restaurant.restaurant(name, hotel_id, address, phone, capacity, opening_time, closing_time)
VALUES('Café Colonial', null, 'Centro Histórico, Ciudad Guatemala', '33667788', 25, '07:00','20:00');

INSERT INTO restaurant.restaurant(name, hotel_id, address, phone, capacity, opening_time, closing_time)
VALUES('Bella Italia', null, 'Zona 14 Ciudad Guatemala', '22994455', 40, '12:00','22:30');

----------------------------------------------------------------------
-- Insertar datos en la tabla restaurant.food_dishes
----------------------------------------------------------------------
-- Nota: Asegúrese de ajustar los restaurant_id para

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'a56ef36a-1972-4ade-9e73-86a582a523a9', 'Tacos al Pastor', 'Tortillas de maíz con cerdo marinado, piña, cebolla y cilantro', 45.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'a56ef36a-1972-4ade-9e73-86a582a523a9', 'Enchiladas Rojas', 'Tortillas rellenas bañadas en salsa roja con queso fresco', 38.50);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'a56ef36a-1972-4ade-9e73-86a582a523a9', 'Pollo en Mole', 'Pechuga de pollo cubierta con mole tradicional y arroz blanco', 52.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'a56ef36a-1972-4ade-9e73-86a582a523a9', 'Carpaccio de Res', 'Láminas finas de res con aceite de oliva y parmesano', 65.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'b465cbd9-970b-4df0-85c7-97e9fc26a21e', 'Ceviche de Camarón', 'Camarón marinado en limón con tomate, cebolla y cilantro', 40.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'b465cbd9-970b-4df0-85c7-97e9fc26a21e', 'Sopa de Tortilla', 'Caldo de jitomate con tiras de tortilla, aguacate y queso', 32.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'b465cbd9-970b-4df0-85c7-97e9fc26a21e', 'Hamburguesa Clásica', 'Carne de res, queso cheddar, lechuga, tomate y papas fritas', 55.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'b465cbd9-970b-4df0-85c7-97e9fc26a21e', 'Pizza Margarita', 'Pizza con base de tomate, mozzarella fresca y albahaca', 70.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'f57f9529-f21d-489b-884b-7cab4c0afdb5', 'Risotto de Champiñones', 'Arroz cremoso con champiñones y parmesano', 80.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'f57f9529-f21d-489b-884b-7cab4c0afdb5', 'Filete de Res a la Parrilla', 'Corte premium acompañado de papas al romero', 120.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'f57f9529-f21d-489b-884b-7cab4c0afdb5', 'Lasaña Boloñesa', 'Capas de pasta con carne molida, salsa de tomate y queso', 75.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'f57f9529-f21d-489b-884b-7cab4c0afdb5', 'Fajitas de Pollo', 'Tiras de pollo con pimientos y cebolla, servidas con tortillas', 58.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), '85060c82-2866-4dc8-9d72-8b42de806dac', 'Camarones al Ajillo', 'Camarones salteados con ajo y vino blanco', 95.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), '85060c82-2866-4dc8-9d72-8b42de806dac', 'Ensalada César', 'Lechuga romana con aderezo César, crutones y parmesano', 42.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), '85060c82-2866-4dc8-9d72-8b42de806dac', 'Sushi Roll California', 'Rollo con cangrejo, aguacate y pepino', 68.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), '85060c82-2866-4dc8-9d72-8b42de806dac', 'Ramen de Cerdo', 'Caldo de miso con fideos, huevo y panceta de cerdo', 85.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'cbb924c3-e685-4de9-a9ff-58627214ac18', 'Pad Thai', 'Fideos de arroz salteados con camarón, tofu y salsa de tamarindo', 88.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'cbb924c3-e685-4de9-a9ff-58627214ac18', 'Cheesecake de Fresa', 'Pastel cremoso con base de galleta y coulis de fresa', 35.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'cbb924c3-e685-4de9-a9ff-58627214ac18', 'Brownie con Helado', 'Brownie de chocolate caliente con bola de helado de vainilla', 30.00);

INSERT INTO restaurant.food_dishes (id, restaurant_id, name, description, price)
VALUES (uuid_generate_v4(), 'cbb924c3-e685-4de9-a9ff-58627214ac18', 'Crepas de Nutella', 'Crepas rellenas de Nutella con fresas frescas', 33.00);