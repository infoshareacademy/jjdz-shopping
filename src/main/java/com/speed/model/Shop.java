package com.speed.model;

import java.net.URI;
import java.util.List;

public interface Shop {
    List<URI> search(TV tv);
}
