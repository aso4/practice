# Write a function that receives a radius as a parameter, and returns the area of a circle: Pi * r^2
def areaOfCirle(radius)
  pi = 3.14
  pi*(radius*radius)
end

# Write a function that receives an array as a parameter, and returns the array reversed. Do not use any built-in reverse function.
def reverseArray(arr)
  i = 0
  reversedArray = []
  while (i < arr.length)
    reversedArray << arr[-1]
  end
  reversedArray
end

def reverseArray2(arr)
  i = 0
  j = -1
  # [1, 2, 3] => [1, 2, 3, 3, 2, 1]
  while(i < arr.length/2)
    saved = arr[i]
    arr[i] = arr[j]
    arr[j] = saved
    i = i + 1
    j = j -1
  end
  arr
end

    
