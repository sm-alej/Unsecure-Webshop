package backend.main.java.database;

import backend.main.java.models.User;

public class DatabaseQueries {

    public static String[] deleteDatabase= new String[]{"DROP TABLE address;", "DROP TABLE article;", "DROP TABLE article_version;", "DROP TABLE brand;",
            "DROP TABLE comment;", "DROP TABLE coupon;", "DROP TABLE picture;", "DROP TABLE sales_order;", "DROP TABLE sales_order_article_version", "DROP TABLE session;",
            "DROP TABLE shopping_cart;", "DROP TABLE shopping_cart_article_version;", "DROP TABLE user;", "DROP TABLE wish_list;", "DROP TABLE wish_list_article_version;"};

    public static String[] createDatabase = new String[]{
            "CREATE TABLE brand(\n" +
                    "    id   INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name text\n" +
                    ");",
            "CREATE TABLE article(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT ,\n" +
                    "    model_name TEXT,\n" +
                    "    price REAL,\n" +
                    "    operating_system TEXT,\n" +
                    "    release_date TEXT,\n" +
                    "    screen TEXT,\n" +
                    "    resolution TEXT,\n" +
                    "    valuation_sum INTEGER,\n" +
                    "    number_of_valuation INTEGER,\n" +
                    "    brand_id INTEGER,\n" +
                    "    FOREIGN KEY(brand_id) REFERENCES brand(id)\n" +
                    ");",
            "CREATE TABLE picture(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    picture_path TEXT,\n" +
                    "    article_id INTEGER,\n" +
                    "    FOREIGN KEY(article_id) REFERENCES article(id)\n" +
                    ");",
            "CREATE TABLE coupon(\n" +
                    "    code TEXT PRIMARY KEY,\n" +
                    "    discount_percent REAL,\n" +
                    "    active INTEGER\n" +
                    ");",
            "CREATE TABLE article_version(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT ,\n" +
                    "    quantity INTEGER,\n" +
                    "    gb_size INTEGER,\n" +
                    "    color TEXT,\n" +
                    "    article_id INTEGER,\n" +
                    "    FOREIGN KEY(article_id) REFERENCES article(id)\n" +
                    ");",
            "CREATE TABLE user(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT ,\n" +
                    "    e_mail TEXT UNIQUE,\n" +
                    "    firstname TEXT,\n" +
                    "    lastname TEXT,\n" +
                    "    password TEXT,\n" +
                    "    newsletter INTEGER,\n" +
                    "    salutation TEXT,\n" +
                    "    title TEXT,\n" +
                    "    profile_picture TEXT,\n" +
                    "    real_user INTEGER, description TEXT\n" +
                    ");",
            "CREATE TABLE wish_list(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    user_id INTEGER,\n" +
                    "    FOREIGN KEY (user_id) REFERENCES user(id)\n" +
                    ");",
            "CREATE TABLE address(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    street_house_number TEXT,\n" +
                    "    postcode TEXT,\n" +
                    "    address_suplement TEXT,\n" +
                    "    city TEXT,\n" +
                    "    country TEXT,\n" +
                    "    name TEXT,\n" +
                    "    delivery_instruction TEXT,\n" +
                    "    user_id INTEGER,\n" +
                    "    FOREIGN KEY (user_id) REFERENCES user(id)\n" +
                    ");",
            "CREATE TABLE session(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    key Text,\n" +
                    "    ip_address Text,\n" +
                    "    user_id INTEGER,\n" +
                    "    FOREIGN KEY (user_id) REFERENCES user(id)\n" +
                    ");",
            "CREATE TABLE wish_list_article_version(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    quantity INTEGER,\n" +
                    "    wish_list_id INTEGER,\n" +
                    "    article_version_id INTEGER,\n" +
                    "    FOREIGN KEY (wish_list_id) REFERENCES wish_list(id),\n" +
                    "    FOREIGN KEY (article_version_id) REFERENCES article_version(id)\n" +
                    ");",
            "CREATE TABLE shopping_cart(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    user_id INTEGER,\n" +
                    "    FOREIGN KEY (user_id) REFERENCES user(id)\n" +
                    ");",
            "CREATE TABLE shopping_cart_article_version(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    quantity INTEGER,\n" +
                    "    shopping_cart_id INTEGER,\n" +
                    "    article_version_id INTEGER,\n" +
                    "    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id),\n" +
                    "    FOREIGN KEY (article_version_id) REFERENCES article_version(id)\n" +
                    ");",
            "CREATE TABLE comment(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    comment_text TEXT,\n" +
                    "    article_id INTEGER,\n" +
                    "    user_id INTEGER,\n" +
                    "    FOREIGN KEY (article_id) REFERENCES article(id),\n" +
                    "    FOREIGN KEY (user_id) REFERENCES user(id)\n" +
                    ");",
            "CREATE TABLE sales_order (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    order_date TEXT,\n" +
                    "    amount REAL,\n" +
                    "    iban TEXT,\n" +
                    "    bic TEXT,\n" +
                    "    account_owner TEXT,\n" +
                    "    user_id INTEGER,\n" +
                    "    address_id INTEGER,\n" +
                    "    coupon_code,\n" +
                    "    FOREIGN KEY (user_id) REFERENCES user(id),\n" +
                    "    FOREIGN KEY (address_id) REFERENCES address(id),\n" +
                    "    FOREIGN KEY (coupon_code) REFERENCES coupon(code)\n" +
                    ");",
            "CREATE TABLE sales_order_article_version(\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    quantity INTEGER,\n" +
                    "    sales_order_id INTEGER,\n" +
                    "    article_version_id INTEGER,\n" +
                    "    FOREIGN KEY (sales_order_id) REFERENCES sales_order(id),\n" +
                    "    FOREIGN KEY (article_version_id) REFERENCES article_version(id)\n" +
                    ");"

    };

    public static String[] brands = new String[]{"Samsung", "Apple", "Xiaomi","Sony"};

    public static User[] users = new User[]{new User(1, "Admin@Admin.de", "admin", "admin", false, "", "", "", "Admin User", "123456789"),
    new User(2, "Test@test.de", "test", "test", false, "", "", "", "Test User", "test123456789")};


}
