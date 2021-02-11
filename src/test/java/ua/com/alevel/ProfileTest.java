package ua.com.alevel;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ua.com.alevel.db.impl.ProfileDBImpl;
import ua.com.alevel.entity.Profile;

import java.util.List;

import static ua.com.alevel.util.ProfileTestUtil.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProfileTest implements AbstractCrudTest{

    @Test
    @Override
    @Order(1)
    public void create() {
        Profile profile = new Profile();
        profile.setProfileName(CREATE_NAME);
        profile.setLastName(LAST_NAME);
        ProfileDBImpl.getInstance().create(profile);
        List<Profile> profiles = ProfileDBImpl.getInstance().readAll();
        Assert.assertTrue(CollectionUtils.isNotEmpty(profiles));
        Assert.assertEquals(profiles.size(), 1);
    }

    @Test
    @Override
    @Order(2)
    public void read() {
        List<Profile> profiles = ProfileDBImpl.getInstance().readAll();
        Assert.assertTrue(CollectionUtils.isNotEmpty(profiles));
        Assert.assertEquals(profiles.size(), 1);
        profiles = ProfileDBImpl.getInstance().read(FIELD_ID, 1);
        Assert.assertTrue(CollectionUtils.isNotEmpty(profiles));
        Assert.assertEquals(profiles.size(), 1);

    }

    @Test
    @Override
    @Order(3)
    public void update() {
        List<Profile> profiles = ProfileDBImpl.getInstance().read(NAME, CREATE_NAME);
        Assert.assertTrue(CollectionUtils.isNotEmpty(profiles));
        Assert.assertEquals(profiles.size(), 1);
        Profile profile = profiles.get(0);
        profile.setProfileName(UPDATE_NAME);
        ProfileDBImpl.getInstance().update(profile);
        profiles = ProfileDBImpl.getInstance().read(NAME, UPDATE_NAME);
        Assert.assertTrue(CollectionUtils.isNotEmpty(profiles));
        Assert.assertEquals(profiles.size(), 1);
    }

    @Test
    @Override
    @Order(4)
    public void delete() {
        List<Profile> profiles = ProfileDBImpl.getInstance().read(NAME, UPDATE_NAME);
        Assert.assertTrue(CollectionUtils.isNotEmpty(profiles));
        Assert.assertEquals(profiles.size(), 1);
        ProfileDBImpl.getInstance().delete(profiles.get(0).getId());
        profiles = ProfileDBImpl.getInstance().read(NAME, UPDATE_NAME);
        Assert.assertTrue(CollectionUtils.isEmpty(profiles));
    }
}
