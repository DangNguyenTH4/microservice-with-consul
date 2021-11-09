package com.learntony.microservice.accountservice.service;

import java.util.List;

public interface AccountService {
    Object add(Object obj);
    Object update(Object obj);
    Object delete(Object obj);
    Object findById(String id);
    List<Object> findByCustomer(String id);
    List<Object> find(List<String> ids);
}
