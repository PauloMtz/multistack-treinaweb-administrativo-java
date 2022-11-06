package com.application.ediaristas.api.assemblers;

import java.util.List;

public interface AssemblerHateoas<R> {
    
    void adicionaLink(R resource);
    void adicionaLinks(List<R> collectionResorces);
}
