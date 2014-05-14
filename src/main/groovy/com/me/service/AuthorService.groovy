package com.me.service

import com.me.config.shared.MyBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by chrislin on 5/12/2014.
 */

@Service
class AuthorService {
    @Autowired
    MyBean myBean
}
