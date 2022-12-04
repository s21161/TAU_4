import unittest

import hamcrest

from Employee import Employee


class EmployeeTest(unittest.TestCase):
    def setUp(self):
        self.temp = Employee()
        self.temp.set_firstname("Andrzej")
        self.temp.set_lastname("Asd")

    def test_initial_firstname(self):
        hamcrest.assert_that(self.temp.get_firstname(), hamcrest.all_of(hamcrest.equal_to("Andrzej"), hamcrest.instance_of(str)))

    def test_initial_lastname(self):
        hamcrest.assert_that(self.temp.get_lastname(), hamcrest.all_of(hamcrest.starts_with("A"), hamcrest.instance_of(str), hamcrest.ends_with("d")))

    def test_set_firstname(self):
        self.temp.set_firstname("Przemysław")
        hamcrest.assert_that(self.temp.get_firstname(), hamcrest.contains_string("Prz"))

    def test_set_lastname(self):
        self.temp.set_lastname("Ala")
        hamcrest.assert_that(self.temp.get_lastname(), hamcrest.starts_with("A"))

    def test_set_wrong_firstname_int(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_firstname).with_args(55))

    def test_set_wrong_firstname(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_firstname).with_args("55.0"),
                             hamcrest.raises(Exception, pattern="Only letters in firstname"))

    def test_set_wrong_lastname_int(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_lastname).with_args(55))

    def test_set_wrong_lastname(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_lastname).with_args("55.0"),
                             hamcrest.raises(Exception, pattern="Only letters in lastname"))

    def tearDown(self):
        self.temp = None
