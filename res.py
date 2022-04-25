import pandas as pd
import yfinance as yf
import sys

data = yf.download(sys.argv[1], interval=sys.argv[2], period= sys.argv[3])
pd.set_option('display.max_rows', None)
pd.set_option('display.max_columns', None)
pd.set_option('display.width', None)
pd.set_option('display.max_colwidth', None)
print(data["Adj Close"])