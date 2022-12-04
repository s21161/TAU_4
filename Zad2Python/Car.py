class Car:
    def __init__(self, __year_model, __make):
        if __year_model < 1970:
            raise Exception("Cars older than 1970 year")
        if not type(__year_model) == int:
            raise Exception("Muse be a int")
        self.__year_model = __year_model
        self.__make = __make
        self.__speed = 0

    def accelerate(self):
        self.__speed = self.__speed + 5

    def brake(self):
        if not self.__speed - 5 < 0:
            self.__speed = self.__speed - 5

    def get_speed(self):
        return self.__speed

    def get_make(self):
        return self.__make
