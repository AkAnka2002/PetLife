<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h4>Редактирование профиля</h4>
    <form method="post" style="text-align: left" enctype="multipart/form-data">
        Кличка: <input type="text" class="my-input" name="name" placeholder="${pet.name}"/><br>
        Вид животного:<select class="form-select" style="width: 65%" aria-label="Select type" name="type">
            <option selected id="type"> ${pet.type} </option>
            <option value="Кот">Кот</option>
            <option value="Собака">Собака</option>
            <option value="Кролик">Кролик</option>
            <option value="Попугай">Попугай</option>
            <option value="Енот">Енот</option>
            <option value="Морская свинка">Морская свинка</option>
            <option value="Хомяк">Хомяк</option>
            <option value="Лошадь">Лошадь</option>
            <option value="Корова">Корова</option>
            <option value="Другое">Другое</option>
        </select><br>
        Порода:<input type="text" class="my-input" name="breed" placeholder="${pet.breed}"/><br><br>
        Гендерная принадлежность:<select class="form-select" style="width: 65%" aria-label="Default select example" name="gender">
            <option selected id="gender"> ${pet.gender} </option>
            <option value="Мужской">Мужской</option>
            <option value="Женский">Женский</option>
            <option value="Другое">Другое</option>
        </select> <br>
        Возраст: <input type="number" name="age" placeholder="${pet.age}"><br><br>
        Кастрация:<select class="form-select" style="width: 65%" aria-label="Select castration" name="castration">
            <option selected id="castration"> ${pet.castration} </option>
            <option value="Да">Да</option>
            <option value="Нет">Нет</option>
        </select><br>
        Описание: <textarea type="text" class="my-input" name="description" placeholder="${pet.description}"></textarea><br><br>
        Фото: <img src="/images/${image.id?c}" height="60ps"/> <br><br>
        <input type="file" class="btn btn-light me-2 btn-my nav_text" name="file"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" class="btn btn-light me-2 btn-my nav_text" value="Изменить профиль питомца"/>
    </form>
</@t.template>