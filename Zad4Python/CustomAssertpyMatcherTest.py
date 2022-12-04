import unittest
from assertpy import assert_that, add_extension, assert_warn

from car import Car


def is_model_of_cars_starts_with_M(self):
    models = ["mazda", "mitsubishi", "maserati"]
    if self.val.lower() not in models:
        return self.error(f'{self.val} is not beginning with letter M')
    return self


def have_legal_speed_in_town(self):
    if self.val > 50:
        return self.error(f'{self.val} is too fast in town area')
    return self


add_extension(is_model_of_cars_starts_with_M)
add_extension(have_legal_speed_in_town)


class CustomAssertpyMatcherTests(unittest.TestCase):
    def test_bentley(self):
        car = Car(2005, "Mazda")
        assert_that(car.get_make()).is_model_of_cars_starts_with_M()

    def test_toyota(self):
        car = Car(2005, "Audi")
        assert_warn(car.get_make()).is_model_of_cars_starts_with_M()

    def test_low_speed(self):
        car = Car(2005, "BMW")
        car.accelerate()
        assert_that(car.get_speed()).have_legal_speed_in_town()

    def test_high_speed(self):
        car = Car(2005, "Seat")
        for _ in range(30):
            car.accelerate()
        assert_warn(car.get_speed()).have_legal_speed_in_town()