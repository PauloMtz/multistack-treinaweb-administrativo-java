package com.application.ediaristas.api.dtos.responses;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.Link;


public class HateoasResponseDto {
    
    private List<LinkResponseDto> links;

    public HateoasResponseDto() {
        links = new ArrayList<>();
    }

    public void adicionarLinks(Link... links) {
        for (Link link : links) {
            var linkResponse = new LinkResponseDto();
            linkResponse.setUri(link.getHref());
            linkResponse.setType(link.getType());
            linkResponse.setRel(link.getRel().value());

            this.links.add(linkResponse);
        }
    }

    public List<LinkResponseDto> getLinks() {
        return links;
    }

    public void setLinks(List<LinkResponseDto> links) {
        this.links = links;
    }
}
