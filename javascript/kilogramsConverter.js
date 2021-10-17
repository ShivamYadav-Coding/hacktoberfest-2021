// A function to convert kilograms to other measurements (pounds, ounces, grams, stones)

function kilogramsConverter(weight) {
  if (typeof weight !== "number") {
    throw new Error("Input must be a valid number.");
  }

  const pounds = weight * 2.2046;
  const ounces = weight * 35.274;
  const grams = weight * 1000;
  const stones = weight * 0.1574;

  return {
    pounds,
    ounces,
    grams,
    stones,
  };
}
