package ua.com.alevel.dao;

import ua.com.alevel.entity.AbstractEntity;
import ua.com.alevel.entity.User;

import java.util.List;

/**
 * @author Iehor Funtusov, created 28/12/2020 - 11:53 AM
 */

public interface AbstractDao<E extends AbstractEntity> {

    void create(E e);
    List<User> read();
    List<User> read(Integer id);
    void update(E e);
    void delete(Integer id);
}
