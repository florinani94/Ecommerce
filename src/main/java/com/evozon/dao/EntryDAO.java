package com.evozon.dao;

import com.evozon.domain.Entry;
import com.evozon.domain.Product;

/**
 * Created by vladblana on 19/07/2016.
 */
public interface EntryDAO {
    void addEntry(Entry entry);
    void deleteEntry(int id);
    void addProductToEntry(Product product);
    Double computeSubTotalForEntry(Integer id);
}
