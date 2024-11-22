# File: example.py

def calculate_sum(numbers):
    result = 0
    for num in numbers:
        result += num
    return result


def is_even(number):
    # This function checks if a number is even
    if number % 2 == 0:
        return True
    else:
        return False


def main():
    nums = [1, 2, 3, 4, 5]
    sum_of_numbers = calculate_sum(nums)

    # Print the result
    print(f"The sum of the numbers is: {sum_of_numbers}")

    redundant_va
