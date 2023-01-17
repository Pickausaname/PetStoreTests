package Resources;

import POJOs.Category;
import POJOs.Pet;
import POJOs.Tag;

import java.util.ArrayList;

public class DataUtils {

    public static Pet createPetObjectWithRandomData() {
        long id = System.currentTimeMillis();
        String petName = "RandomPetName" + id;

        Category category = new Category();
        category.setId(id);
        category.setName("RandomName_" + id);

        Tag tag = new Tag();
        tag.setId(id);
        tag.setName("RandomTagName"+id);
        ArrayList<Tag> tagArrayList = new ArrayList<>();
        tagArrayList.add(tag);

        StatusEnum statusEnum = StatusEnum.AVAILABLE;

        return new Pet(id, category, petName, new ArrayList<String>(), tagArrayList, statusEnum);
    }
}
