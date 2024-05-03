<!DOCTYPE html>
<html>
    <head>
        <title>TIMETABLE</title>
    </head>
    <body>
        <h1>TIMETABLE</h1><hr>
        <h4>События</h4>
        <form action="/events" method="get">
            Поиск по название события: <input type="text" name="title"/><br>
            <input type="submit" value="Поиск"/>
        </form>
        <#list events as event>
            <div>
                <p><b>${event.title}</b> ${event.date} | <a href="/event/${event.id}">Подробнее...</a></p>
            </div>
            <#else>
            <h2>Нет событий<h2>
        </#list>
        <hr>
        <h3>Создать событие</h3>
        <form action="/event/create" method="post">
            Название события:   <input type="text" name="title"/><br><br>
            Описание:           <input type="text" name="description"/><br><br>
            Дата и вермя:       <input type="text" name="date"/><br><br>
            Место:              <input type="text" name="place"/><br><br>
            <input type="submit" value="Добавить событие"/>
        </form>
    </body>
</html>