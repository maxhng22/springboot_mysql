package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository; // Mocked database

    @InjectMocks
    private ItemService itemService; // Service to test

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testGetAllItems() {
        // Arrange: Mock database response
        List<Item> mockItems = Arrays.asList(new Item("Item1", "Item1", 10.0), new Item("2L", "Item2", 20.0));
        when(itemRepository.findAll()).thenReturn(mockItems);

        // Act: Call service method
        List<Item> result = itemService.getAllItems();

        // Assert: Check if result is correct
        assertEquals(2, result.size());
        assertEquals("Item1", result.get(0).getName());
        verify(itemRepository, times(1)).findAll(); // Ensure repository method was called once
    }

    @Test
    void testGetItemById_Success() {
        // Arrange
        Item mockItem = new Item("Item1", "Item1", 10.0); // Fix 1: Use Long, not String
        when(itemRepository.findById(1L)).thenReturn(Optional.of(mockItem));

        // Act
        Optional<Item> result = itemService.getItemById(1L);

        // Assert
        assertTrue(result.isPresent());  // Ensure Optional is not empty
        assertEquals("Item1", result.get().getName());  // Fix 2: Use get() to access Item
    }



    @Test
    void testAddItem() {
        // Arrange
        Item newItem = new Item("NewItem", "NewItem", 30.0);
        Item savedItem = new Item("NewItem", "NewItem", 30.0);
        when(itemRepository.save(newItem)).thenReturn(savedItem);

        // Act
        Item result = itemService.saveItem(newItem);

        // Assert
        assertNotNull(result.getName());
        assertEquals("NewItem", result.getName());
    }


}
