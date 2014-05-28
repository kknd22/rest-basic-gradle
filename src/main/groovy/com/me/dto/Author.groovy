package com.me.dto

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
/**
 * Created by chrislin on 5/6/2014.
 */
@ApiModel( value = "Author", description = "Author resource representation" )
public class Author {
    @ApiModelProperty( value = "Author's first name", required = true )
    String name

    @ApiModelProperty( value = "Author's id", required = true )
    Integer id

    @ApiModelProperty( value = "Books published by the Author", required = false )
    List<Book> books

}
