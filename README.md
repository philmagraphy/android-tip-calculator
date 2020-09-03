Fairly simple to use, there are 2 fields:

Check Amount (type double)
Party Size (type int)

Check Amount must be >= 0
Party Size must be >= 1

Valid types will lead to 7 calculated fields:

Amount (per person)
15% Tip
20% Tip
25% Tip
Total with 15% tip (amount + 15% tip)
Total with 20% tip (amount + 20% tip)
Total with 25% tip (amount + 25% tip)

During calculations, double values will be rounded before conversion into integers.
Should any invalid values be entered (letters, non-numeric symbols, values outside respective range) a toast message will notify the user.
