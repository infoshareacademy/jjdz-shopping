package com.speed.model;

import com.speed.service.UserNotAuthorisedExeption;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by ewa on 6/20/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class FavoritesDBTest {

    @Mock
    SessionData sessionData;

    @Mock
    EntityManager em;

    @InjectMocks
    FavoritesDB cut;

    private Category category1 = new Category(67252, 67236, "LED");
    private Category category2 = new Category(55555, 66666, "RES");

    private Set<Category> favorit_Cat = new HashSet<>();
    private Set<Category> favorit_Cat_All = new HashSet<>();


    @Before
    public void init() {
        favorit_Cat.add(category2);
        favorit_Cat_All.add(category1);
        favorit_Cat_All.add(category2);
    }

    @Test
    public void testRemoveFromFavourites() throws UserNotAuthorisedExeption {
        //given

        UsersData user = new UsersData();
        user.getFavorites().add(category1);
        user.getFavorites().add(category2);

        //when
        when(sessionData.getUser()).thenReturn(Optional.of(user));
        cut.removeFromFavorites(category1);

        //then
        assertEquals("Nie usuwa ulubionych", user.getFavorites(), favorit_Cat);

    }

    @Test
    public void testRemovefromEmptyFavorites() throws UserNotAuthorisedExeption {

        //given

        UsersData user = new UsersData();
        Set<Category> result = new HashSet<>();
        user.getFavorites().addAll(result);

        //when
        when(sessionData.getUser()).thenReturn(Optional.of(user));
        cut.removeFromFavorites(category1);

        //then
        assertEquals("Nie usuwa ulubionych", user.getFavorites(), result);

    }

    @Test (expected = UserNotAuthorisedExeption.class)
    public void testNotLoggedAddToFavorites() throws UserNotAuthorisedExeption {
        //given
        UsersData user = new UsersData();

        //when
        when(sessionData.getUser()).thenReturn(Optional.empty());
        cut.addToFavorites(category2);

        // then throw exception
    }

    @Test
    public void testAddToFavourites() throws UserNotAuthorisedExeption {

        //given
        UsersData user = new UsersData();
        user.getFavorites().add(category1);

        //when

        when(sessionData.getUser()).thenReturn(Optional.of(user));
        when(em.merge(category2)).thenReturn(category2);
        cut.addToFavorites(category2);

        //then
        assertEquals("Nie dodaje ulubionych", user.getFavorites(), favorit_Cat_All);

    }


}