package com.amx.assestment.exceptions

import java.lang.RuntimeException

class UserNotFoundException (message: String) : RuntimeException(message)
class UserNoContentException (message: String) : RuntimeException(message)