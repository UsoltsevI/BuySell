<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>BUYSELL</title>
    <link rel="stylesheet" href="products.css">
</head>
<body>
    <header>
        <ul class="title-list">
            <li class="title-li-ref">
                <a href="#" class="title-for">О нас</a>
            </li>
            <li class="title-li-ref">
                <a href="#" class="title-for">Для бизнеса</a>
            </li>
            <li class="title-li-ref">
                <a href="#" class="title-for">Каталоги</a>
            </li>
            <li class="title-li-ref">
                <a href="#" class="title-for">Вход и регистрация</a>
            </li>
            <li class="title-li-ref">
                <a href="#" class="title-for">
                    <img src="cartIcon2.png" class="title-cart" width="40" height="40"/>
                </a>
            </li>
        </ul>
    </header>
    <main class="main">
        <div class="search-menu">
            <form action="/" method="get">
                <a href="#" class="buysell-search">BUYSELL</a>
                <span class="search-pair">
                    <input id="search_line_id" class="search-line" type="text" name="title" placeholder="Поиск по объявлениям"/>
                    <input class="search-bottom" type="submit" value="Поиск"/>
                </span>
            </form>
        </div>
        <div class="list-of-products">
            <#list products as product>
                <div class="product">
                    <p><b>${product.title}</b> ${product.price} руб. | <a class="product-more" href="/product/${product.id}">Подробнее...</a></p>
                </div>
                <#else>
                <h3>Товаров нет</h3>
            </#list>
        </div>
    </main>

    <h3>Создать новый товар</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        <div class="product_info_div">
        <label for="product_name_id" class="product_label">Название объявления:</label>    
        <input id ="product_name_id" type="text" name="title"/>
        </div>
        <div class="product_info_div">
        <label for="product_description_id" class="product_label">Описание объявления:</label>    
        <input id ="product_description_id" type="text" name="description" class="product_info_input"/>
        </div>
        <div class="product_info_div">
        <label for="product_price_id" class="product_label">Цена:</label>                   
        <input id ="product_price_id" type="number" name="price" class="product_info_input"/>
        </div>
        <div class="product_info_div">
        <label for="product_city_id" class="product_label">Город:</label>
        <input id ="product_city_id" type="text" name="city" class="product_info_input"/>
        </div>
        <div class="product_info_div">
        <label for="product_author_id" class="product_label">Имя:</label>
        <input id="product_author_id" type="text" name="author" class="product_info_input"/>
        </div>
        <div class="product_info_div">
        <label for="product_file1_id" class="product_label">Фото 1:</label>
        <input id="product_file1_id" type="file" name="file1" class="product_info_input"/>
        </div>
        <div class="product_info_div">
        <label for="product_file2_id" class="product_label">Фото 2:</label>
        <input id="product_file2_id" type="file" name="file2" class="product_info_input"/>
        </div>
        <div class="product_info_div">
        <label for="product_file3_id" class="product_label">Фото 3:</label>
        <input id="product_file3_id" type="file" name="file3" class="product_info_input"/>
        </div>
        <input type="submit" value="Добавить товар"/>
    </form>

    <h3>Перейти к расписанию</h3>
    <p><a href="/events">События</a></p>
</body>
</html>