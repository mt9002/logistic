package com.api.integration.factory;

import com.api.domain.models.auth.Role;
import com.api.domain.models.auth.Client;
import com.github.javafaker.Faker;

public class UserFactory {

    public static Client createUser() {
        Faker faker = new Faker();
        Client client = new Client();
        client.setName(faker.name().firstName());
        client.setLastName(faker.name().lastName());
        client.setEmail(faker.internet().emailAddress());
        client.setRole(Role.valueOf("USER"));
        return client;
    }
}
