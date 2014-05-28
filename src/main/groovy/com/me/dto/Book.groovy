package com.me.dto

import com.me.resource.AuthorResource
import com.wordnik.swagger.annotations.ApiModel
import com.wordnik.swagger.annotations.ApiModelProperty

/**
 * Created by chrislin on 5/6/2014.
 */
@ApiModel( value = "Book", description = "Book resource representation" )
class Book {
    @ApiModelProperty( value = "Identification of the book", required = true )
    String id

    @ApiModelProperty( value = "Title of the book", required = false )
    String title

}
