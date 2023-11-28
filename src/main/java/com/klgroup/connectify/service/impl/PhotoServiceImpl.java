package com.klgroup.connectify.service.impl;

import com.klgroup.connectify.model.Photo;
import com.klgroup.connectify.repository.PhotoReposity;
import com.klgroup.connectify.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoReposity photoReposity;

    @Override
    public List<Photo> getAllPhoto(){return photoReposity.findAll();}
}
