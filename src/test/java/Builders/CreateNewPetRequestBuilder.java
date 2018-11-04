package Builders;

import entities.request.Category;
import entities.request.Tags;
import entities.request.createPetRequest;

public class CreateNewPetRequestBuilder {


    private createPetRequest createPetRequest = new createPetRequest();

    public CreateNewPetRequestBuilder withTags(Tags[] tags) {
        createPetRequest.setTags(tags);
        return this;
    }

    public CreateNewPetRequestBuilder withCategory(Category category) {
        createPetRequest.setCategory(category);
        return this;
    }

    public CreateNewPetRequestBuilder withId(int id) {
        createPetRequest.setId(id);
        return this;
    }

    public CreateNewPetRequestBuilder withStatus(String status) {
        createPetRequest.setStatus(status);
        return this;
    }

    public CreateNewPetRequestBuilder withName(String name) {
        createPetRequest.setName(name);
        return this;
    }

    public CreateNewPetRequestBuilder withPhotoUrls(String[] photoUrls) {
        createPetRequest.setPhotoUrls(photoUrls);
        return this;
    }

    public createPetRequest build() {
        return createPetRequest;
    }


}

