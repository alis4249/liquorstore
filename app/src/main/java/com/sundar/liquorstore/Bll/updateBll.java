package com.sundar.liquorstore.Bll;

import com.sundar.liquorstore.Api.updateApi;
import com.sundar.liquorstore.Url.url;

public class updateBll {
    updateApi Update  = url.getInstance().create(updateApi.class);
}
