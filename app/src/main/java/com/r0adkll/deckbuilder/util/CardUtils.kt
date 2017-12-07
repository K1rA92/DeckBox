package com.r0adkll.deckbuilder.util


object CardUtils {
    val CARDS: Array<String> = arrayOf(
            "https://images.pokemontcg.io/sm2/14.png",
            "https://images.pokemontcg.io/sm1/109.png",
            "https://images.pokemontcg.io/sm2/102.png",
            "https://images.pokemontcg.io/sm2/110.png",
            "https://images.pokemontcg.io/sm1/103.png",
            "https://images.pokemontcg.io/sm3/116.png",
            "https://images.pokemontcg.io/sm4/93.png",
            "https://images.pokemontcg.io/sm35/16.png",
            "https://images.pokemontcg.io/sm2/55.png",
            "https://images.pokemontcg.io/sm1/29.png",
            "https://images.pokemontcg.io/sm2/41.png",
            "https://images.pokemontcg.io/sm3/143.png",
            "https://images.pokemontcg.io/sm3/10.png",
            "https://images.pokemontcg.io/sm3/128.png",
            "https://images.pokemontcg.io/sm2/32.png",
            "https://images.pokemontcg.io/sm2/29.png",
            "https://images.pokemontcg.io/sm3/84.png",
            "https://images.pokemontcg.io/sm1/54.png",
            "https://images.pokemontcg.io/sm2/142.png",
            "https://images.pokemontcg.io/sm1/26.png",
            "https://images.pokemontcg.io/sm35/57.png",
            "https://images.pokemontcg.io/sm1/38.png",
            "https://images.pokemontcg.io/sm4/78.png",
            "https://images.pokemontcg.io/sm1/18.png",
            "https://images.pokemontcg.io/sm4/82.png",
            "https://images.pokemontcg.io/sm1/136.png",
            "https://images.pokemontcg.io/sm35/19.png",
            "https://images.pokemontcg.io/sm35/37.png",
            "https://images.pokemontcg.io/sm2/95.png",
            "https://images.pokemontcg.io/sm3/120.png",
            "https://images.pokemontcg.io/sm1/134.png",
            "https://images.pokemontcg.io/sm3/38.png",
            "https://images.pokemontcg.io/sm4/89.png",
            "https://images.pokemontcg.io/sm1/67.png",
            "https://images.pokemontcg.io/sm1/140.png",
            "https://images.pokemontcg.io/sm35/10.png",
            "https://images.pokemontcg.io/sm4/1.png",
            "https://images.pokemontcg.io/sm35/73.png",
            "https://images.pokemontcg.io/sm35/29.png",
            "https://images.pokemontcg.io/sm35/4.png",
            "https://images.pokemontcg.io/sm1/146.png",
            "https://images.pokemontcg.io/sm4/109.png",
            "https://images.pokemontcg.io/sm3/11.png",
            "https://images.pokemontcg.io/sm2/114.png",
            "https://images.pokemontcg.io/sm2/120.png",
            "https://images.pokemontcg.io/sm2/2.png",
            "https://images.pokemontcg.io/sm1/35.png",
            "https://images.pokemontcg.io/sm35/38.png",
            "https://images.pokemontcg.io/sm3/17.png",
            "https://images.pokemontcg.io/sm4/27.png",
            "https://images.pokemontcg.io/sm1/43.png",
            "https://images.pokemontcg.io/sm3/71.png",
            "https://images.pokemontcg.io/sm2/73.png",
            "https://images.pokemontcg.io/sm2/132.png",
            "https://images.pokemontcg.io/sm1/142.png",
            "https://images.pokemontcg.io/sm1/132.png",
            "https://images.pokemontcg.io/sm3/27.png",
            "https://images.pokemontcg.io/sm2/69.png",
            "https://images.pokemontcg.io/sm1/133.png",
            "https://images.pokemontcg.io/sm2/116.png",
            "https://images.pokemontcg.io/sm3/76.png",
            "https://images.pokemontcg.io/sm1/144.png",
            "https://images.pokemontcg.io/sm3/107.png",
            "https://images.pokemontcg.io/sm3/122.png",
            "https://images.pokemontcg.io/sm35/45.png",
            "https://images.pokemontcg.io/sm4/67.png",
            "https://images.pokemontcg.io/sm2/5.png",
            "https://images.pokemontcg.io/sm35/46.png",
            "https://images.pokemontcg.io/sm35/8.png",
            "https://images.pokemontcg.io/sm2/136.png",
            "https://images.pokemontcg.io/sm1/19.png",
            "https://images.pokemontcg.io/sm3/69.png",
            "https://images.pokemontcg.io/sm2/62.png",
            "https://images.pokemontcg.io/sm2/118.png",
            "https://images.pokemontcg.io/sm3/22.png",
            "https://images.pokemontcg.io/sm3/6.png",
            "https://images.pokemontcg.io/sm35/22.png",
            "https://images.pokemontcg.io/sm3/127.png",
            "https://images.pokemontcg.io/sm2/10.png",
            "https://images.pokemontcg.io/sm2/59.png",
            "https://images.pokemontcg.io/sm35/27.png",
            "https://images.pokemontcg.io/sm4/91.png",
            "https://images.pokemontcg.io/sm2/47.png",
            "https://images.pokemontcg.io/sm2/38.png",
            "https://images.pokemontcg.io/sm4/7.png",
            "https://images.pokemontcg.io/sm4/75.png",
            "https://images.pokemontcg.io/sm1/101.png",
            "https://images.pokemontcg.io/sm35/53.png",
            "https://images.pokemontcg.io/sm3/147.png",
            "https://images.pokemontcg.io/sm3/144.png",
            "https://images.pokemontcg.io/sm3/14.png",
            "https://images.pokemontcg.io/sm1/118.png",
            "https://images.pokemontcg.io/sm35/30.png",
            "https://images.pokemontcg.io/sm3/13.png",
            "https://images.pokemontcg.io/sm2/40.png",
            "https://images.pokemontcg.io/sm2/99.png",
            "https://images.pokemontcg.io/sm3/26.png",
            "https://images.pokemontcg.io/sm3/48.png",
            "https://images.pokemontcg.io/sm4/57.png",
            "https://images.pokemontcg.io/sm4/100.png",
            "https://images.pokemontcg.io/sm1/131.png",
            "https://images.pokemontcg.io/sm35/41.png",
            "https://images.pokemontcg.io/sm1/115.png",
            "https://images.pokemontcg.io/sm2/122.png",
            "https://images.pokemontcg.io/sm4/70.png",
            "https://images.pokemontcg.io/sm2/30.png",
            "https://images.pokemontcg.io/sm2/78.png",
            "https://images.pokemontcg.io/sm3/115.png",
            "https://images.pokemontcg.io/sm4/84.png",
            "https://images.pokemontcg.io/sm2/80.png",
            "https://images.pokemontcg.io/sm3/42.png",
            "https://images.pokemontcg.io/sm3/138.png",
            "https://images.pokemontcg.io/sm4/58.png",
            "https://images.pokemontcg.io/sm35/75.png",
            "https://images.pokemontcg.io/sm4/44.png",
            "https://images.pokemontcg.io/sm4/66.png",
            "https://images.pokemontcg.io/sm1/2.png",
            "https://images.pokemontcg.io/sm1/75.png",
            "https://images.pokemontcg.io/sm3/110.png",
            "https://images.pokemontcg.io/sm3/39.png",
            "https://images.pokemontcg.io/sm4/85.png",
            "https://images.pokemontcg.io/sm1/98.png",
            "https://images.pokemontcg.io/sm1/28.png",
            "https://images.pokemontcg.io/sm4/38.png",
            "https://images.pokemontcg.io/sm1/76.png",
            "https://images.pokemontcg.io/sm2/35.png",
            "https://images.pokemontcg.io/sm2/76.png",
            "https://images.pokemontcg.io/sm4/103.png",
            "https://images.pokemontcg.io/sm2/130.png",
            "https://images.pokemontcg.io/sm1/13.png",
            "https://images.pokemontcg.io/sm3/67.png",
            "https://images.pokemontcg.io/sm1/8.png",
            "https://images.pokemontcg.io/sm1/34.png",
            "https://images.pokemontcg.io/sm1/30.png",
            "https://images.pokemontcg.io/sm1/141.png",
            "https://images.pokemontcg.io/sm1/7.png",
            "https://images.pokemontcg.io/sm3/46.png",
            "https://images.pokemontcg.io/sm35/55.png",
            "https://images.pokemontcg.io/sm2/12.png",
            "https://images.pokemontcg.io/sm2/24.png",
            "https://images.pokemontcg.io/sm1/65.png",
            "https://images.pokemontcg.io/sm2/9.png",
            "https://images.pokemontcg.io/sm2/125.png",
            "https://images.pokemontcg.io/sm1/108.png",
            "https://images.pokemontcg.io/sm4/95.png",
            "https://images.pokemontcg.io/sm1/147.png",
            "https://images.pokemontcg.io/sm4/102.png",
            "https://images.pokemontcg.io/sm2/63.png",
            "https://images.pokemontcg.io/sm1/94.png",
            "https://images.pokemontcg.io/sm2/70.png",
            "https://images.pokemontcg.io/sm1/10.png",
            "https://images.pokemontcg.io/sm35/62.png",
            "https://images.pokemontcg.io/sm4/11.png",
            "https://images.pokemontcg.io/sm3/95.png",
            "https://images.pokemontcg.io/sm3/130.png",
            "https://images.pokemontcg.io/sm35/64.png",
            "https://images.pokemontcg.io/sm3/90.png",
            "https://images.pokemontcg.io/sm4/81.png",
            "https://images.pokemontcg.io/sm4/110.png",
            "https://images.pokemontcg.io/sm2/15.png",
            "https://images.pokemontcg.io/sm1/119.png",
            "https://images.pokemontcg.io/sm3/113.png",
            "https://images.pokemontcg.io/sm2/117.png",
            "https://images.pokemontcg.io/sm1/58.png",
            "https://images.pokemontcg.io/sm35/76.png",
            "https://images.pokemontcg.io/sm3/98.png",
            "https://images.pokemontcg.io/sm4/79.png",
            "https://images.pokemontcg.io/sm2/93.png",
            "https://images.pokemontcg.io/sm35/47.png",
            "https://images.pokemontcg.io/sm1/100.png",
            "https://images.pokemontcg.io/sm3/118.png",
            "https://images.pokemontcg.io/sm1/53.png",
            "https://images.pokemontcg.io/sm4/3.png",
            "https://images.pokemontcg.io/sm2/11.png",
            "https://images.pokemontcg.io/sm4/90.png",
            "https://images.pokemontcg.io/sm35/39.png",
            "https://images.pokemontcg.io/sm2/71.png",
            "https://images.pokemontcg.io/sm2/18.png",
            "https://images.pokemontcg.io/sm3/63.png",
            "https://images.pokemontcg.io/sm4/23.png",
            "https://images.pokemontcg.io/sm4/77.png",
            "https://images.pokemontcg.io/sm2/90.png",
            "https://images.pokemontcg.io/sm1/23.png",
            "https://images.pokemontcg.io/sm2/16.png",
            "https://images.pokemontcg.io/sm1/50.png",
            "https://images.pokemontcg.io/sm1/14.png",
            "https://images.pokemontcg.io/sm4/87.png",
            "https://images.pokemontcg.io/sm2/128.png",
            "https://images.pokemontcg.io/sm3/2.png",
            "https://images.pokemontcg.io/sm3/105.png",
            "https://images.pokemontcg.io/sm4/45.png",
            "https://images.pokemontcg.io/sm1/20.png",
            "https://images.pokemontcg.io/sm35/12.png",
            "https://images.pokemontcg.io/sm4/32.png",
            "https://images.pokemontcg.io/sm3/97.png",
            "https://images.pokemontcg.io/sm3/135.png",
            "https://images.pokemontcg.io/sm35/35.png",
            "https://images.pokemontcg.io/sm1/96.png",
            "https://images.pokemontcg.io/sm35/34.png",
            "https://images.pokemontcg.io/sm2/26.png",
            "https://images.pokemontcg.io/sm35/17.png",
            "https://images.pokemontcg.io/sm3/31.png",
            "https://images.pokemontcg.io/sm4/36.png",
            "https://images.pokemontcg.io/sm1/22.png",
            "https://images.pokemontcg.io/sm3/114.png",
            "https://images.pokemontcg.io/sm4/6.png",
            "https://images.pokemontcg.io/sm2/31.png",
            "https://images.pokemontcg.io/sm3/16.png",
            "https://images.pokemontcg.io/sm4/111.png",
            "https://images.pokemontcg.io/sm3/15.png",
            "https://images.pokemontcg.io/sm4/51.png",
            "https://images.pokemontcg.io/sm1/95.png",
            "https://images.pokemontcg.io/sm4/48.png",
            "https://images.pokemontcg.io/sm4/31.png",
            "https://images.pokemontcg.io/sm3/74.png",
            "https://images.pokemontcg.io/sm2/129.png",
            "https://images.pokemontcg.io/sm4/99.png",
            "https://images.pokemontcg.io/sm2/89.png",
            "https://images.pokemontcg.io/sm4/4.png",
            "https://images.pokemontcg.io/sm4/50.png",
            "https://images.pokemontcg.io/sm4/68.png",
            "https://images.pokemontcg.io/sm3/50.png",
            "https://images.pokemontcg.io/sm1/68.png",
            "https://images.pokemontcg.io/sm3/66.png",
            "https://images.pokemontcg.io/sm4/17.png",
            "https://images.pokemontcg.io/sm4/16.png",
            "https://images.pokemontcg.io/sm3/112.png",
            "https://images.pokemontcg.io/sm2/4.png",
            "https://images.pokemontcg.io/sm3/119.png",
            "https://images.pokemontcg.io/sm35/42.png",
            "https://images.pokemontcg.io/sm1/77.png",
            "https://images.pokemontcg.io/sm2/57.png",
            "https://images.pokemontcg.io/sm1/124.png",
            "https://images.pokemontcg.io/sm1/127.png",
            "https://images.pokemontcg.io/sm4/107.png",
            "https://images.pokemontcg.io/sm1/83.png",
            "https://images.pokemontcg.io/sm3/36.png",
            "https://images.pokemontcg.io/sm3/33.png",
            "https://images.pokemontcg.io/sm3/87.png",
            "https://images.pokemontcg.io/sm1/16.png",
            "https://images.pokemontcg.io/sm2/6.png",
            "https://images.pokemontcg.io/sm1/85.png",
            "https://images.pokemontcg.io/sm1/73.png",
            "https://images.pokemontcg.io/sm3/4.png",
            "https://images.pokemontcg.io/sm4/29.png",
            "https://images.pokemontcg.io/sm1/5.png",
            "https://images.pokemontcg.io/sm2/140.png",
            "https://images.pokemontcg.io/sm1/120.png",
            "https://images.pokemontcg.io/sm2/44.png",
            "https://images.pokemontcg.io/sm4/106.png",
            "https://images.pokemontcg.io/sm3/61.png",
            "https://images.pokemontcg.io/sm2/91.png",
            "https://images.pokemontcg.io/sm2/39.png",
            "https://images.pokemontcg.io/sm1/57.png",
            "https://images.pokemontcg.io/sm4/25.png",
            "https://images.pokemontcg.io/sm3/94.png",
            "https://images.pokemontcg.io/sm2/67.png",
            "https://images.pokemontcg.io/sm2/45.png",
            "https://images.pokemontcg.io/sm3/25.png",
            "https://images.pokemontcg.io/sm3/126.png",
            "https://images.pokemontcg.io/sm4/41.png",
            "https://images.pokemontcg.io/sm35/28.png",
            "https://images.pokemontcg.io/sm3/57.png",
            "https://images.pokemontcg.io/sm2/1.png",
            "https://images.pokemontcg.io/sm3/104.png",
            "https://images.pokemontcg.io/sm35/60.png",
            "https://images.pokemontcg.io/sm1/59.png",
            "https://images.pokemontcg.io/sm35/49.png",
            "https://images.pokemontcg.io/sm2/51.png",
            "https://images.pokemontcg.io/sm35/26.png",
            "https://images.pokemontcg.io/sm3/132.png",
            "https://images.pokemontcg.io/sm35/67.png",
            "https://images.pokemontcg.io/sm1/107.png",
            "https://images.pokemontcg.io/sm2/127.png",
            "https://images.pokemontcg.io/sm2/43.png",
            "https://images.pokemontcg.io/sm1/149.png",
            "https://images.pokemontcg.io/sm3/52.png",
            "https://images.pokemontcg.io/sm1/86.png",
            "https://images.pokemontcg.io/sm1/25.png",
            "https://images.pokemontcg.io/sm1/122.png",
            "https://images.pokemontcg.io/sm3/88.png",
            "https://images.pokemontcg.io/sm1/74.png",
            "https://images.pokemontcg.io/sm2/134.png",
            "https://images.pokemontcg.io/sm3/3.png",
            "https://images.pokemontcg.io/sm4/80.png",
            "https://images.pokemontcg.io/sm4/28.png",
            "https://images.pokemontcg.io/sm2/94.png",
            "https://images.pokemontcg.io/sm35/21.png",
            "https://images.pokemontcg.io/sm1/45.png",
            "https://images.pokemontcg.io/sm2/13.png",
            "https://images.pokemontcg.io/sm1/17.png",
            "https://images.pokemontcg.io/sm3/54.png",
            "https://images.pokemontcg.io/sm2/111.png",
            "https://images.pokemontcg.io/sm2/52.png",
            "https://images.pokemontcg.io/sm3/101.png",
            "https://images.pokemontcg.io/sm1/11.png",
            "https://images.pokemontcg.io/sm4/2.png",
            "https://images.pokemontcg.io/sm35/18.png",
            "https://images.pokemontcg.io/sm2/124.png",
            "https://images.pokemontcg.io/sm3/70.png",
            "https://images.pokemontcg.io/sm3/68.png",
            "https://images.pokemontcg.io/sm3/92.png",
            "https://images.pokemontcg.io/sm1/55.png",
            "https://images.pokemontcg.io/sm2/49.png",
            "https://images.pokemontcg.io/sm1/143.png",
            "https://images.pokemontcg.io/sm3/103.png",
            "https://images.pokemontcg.io/sm3/7.png",
            "https://images.pokemontcg.io/sm1/46.png",
            "https://images.pokemontcg.io/sm3/64.png",
            "https://images.pokemontcg.io/sm1/145.png",
            "https://images.pokemontcg.io/sm1/51.png",
            "https://images.pokemontcg.io/sm3/123.png",
            "https://images.pokemontcg.io/sm2/138.png",
            "https://images.pokemontcg.io/sm2/126.png",
            "https://images.pokemontcg.io/sm1/88.png",
            "https://images.pokemontcg.io/sm2/53.png",
            "https://images.pokemontcg.io/sm3/89.png",
            "https://images.pokemontcg.io/sm3/58.png",
            "https://images.pokemontcg.io/sm35/66.png",
            "https://images.pokemontcg.io/sm2/21.png",
            "https://images.pokemontcg.io/sm1/52.png",
            "https://images.pokemontcg.io/sm1/63.png",
            "https://images.pokemontcg.io/sm3/100.png",
            "https://images.pokemontcg.io/sm35/56.png",
            "https://images.pokemontcg.io/sm1/33.png",
            "https://images.pokemontcg.io/sm4/96.png",
            "https://images.pokemontcg.io/sm3/146.png",
            "https://images.pokemontcg.io/sm35/40.png",
            "https://images.pokemontcg.io/sm3/136.png",
            "https://images.pokemontcg.io/sm2/36.png",
            "https://images.pokemontcg.io/sm3/62.png",
            "https://images.pokemontcg.io/sm1/71.png",
            "https://images.pokemontcg.io/sm3/93.png",
            "https://images.pokemontcg.io/sm3/124.png",
            "https://images.pokemontcg.io/sm3/56.png",
            "https://images.pokemontcg.io/sm2/104.png",
            "https://images.pokemontcg.io/sm35/77.png",
            "https://images.pokemontcg.io/sm1/102.png",
            "https://images.pokemontcg.io/sm1/121.png",
            "https://images.pokemontcg.io/sm3/20.png",
            "https://images.pokemontcg.io/sm3/59.png",
            "https://images.pokemontcg.io/sm2/97.png",
            "https://images.pokemontcg.io/sm4/63.png",
            "https://images.pokemontcg.io/sm3/34.png",
            "https://images.pokemontcg.io/sm35/3.png",
            "https://images.pokemontcg.io/sm1/92.png",
            "https://images.pokemontcg.io/sm2/145.png",
            "https://images.pokemontcg.io/sm1/110.png",
            "https://images.pokemontcg.io/sm3/82.png",
            "https://images.pokemontcg.io/sm3/29.png",
            "https://images.pokemontcg.io/sm1/9.png",
            "https://images.pokemontcg.io/sm1/112.png",
            "https://images.pokemontcg.io/sm4/22.png",
            "https://images.pokemontcg.io/sm2/108.png",
            "https://images.pokemontcg.io/sm4/39.png",
            "https://images.pokemontcg.io/sm4/60.png",
            "https://images.pokemontcg.io/sm3/65.png",
            "https://images.pokemontcg.io/sm1/66.png",
            "https://images.pokemontcg.io/sm3/83.png",
            "https://images.pokemontcg.io/sm35/68.png",
            "https://images.pokemontcg.io/sm1/49.png",
            "https://images.pokemontcg.io/sm4/104.png",
            "https://images.pokemontcg.io/sm2/137.png",
            "https://images.pokemontcg.io/sm4/65.png",
            "https://images.pokemontcg.io/sm2/28.png",
            "https://images.pokemontcg.io/sm2/107.png",
            "https://images.pokemontcg.io/sm3/121.png",
            "https://images.pokemontcg.io/sm4/19.png",
            "https://images.pokemontcg.io/sm1/130.png",
            "https://images.pokemontcg.io/sm1/99.png",
            "https://images.pokemontcg.io/sm4/56.png",
            "https://images.pokemontcg.io/sm3/24.png",
            "https://images.pokemontcg.io/sm3/99.png",
            "https://images.pokemontcg.io/sm2/48.png",
            "https://images.pokemontcg.io/sm35/58.png",
            "https://images.pokemontcg.io/sm35/61.png",
            "https://images.pokemontcg.io/sm2/66.png",
            "https://images.pokemontcg.io/sm4/59.png",
            "https://images.pokemontcg.io/sm1/39.png",
            "https://images.pokemontcg.io/sm1/15.png",
            "https://images.pokemontcg.io/sm2/135.png",
            "https://images.pokemontcg.io/sm35/50.png",
            "https://images.pokemontcg.io/sm35/72.png",
            "https://images.pokemontcg.io/sm3/85.png",
            "https://images.pokemontcg.io/sm4/72.png",
            "https://images.pokemontcg.io/sm3/79.png",
            "https://images.pokemontcg.io/sm1/80.png",
            "https://images.pokemontcg.io/sm2/86.png",
            "https://images.pokemontcg.io/sm1/1.png",
            "https://images.pokemontcg.io/sm2/27.png",
            "https://images.pokemontcg.io/sm2/22.png",
            "https://images.pokemontcg.io/sm2/123.png",
            "https://images.pokemontcg.io/sm2/20.png",
            "https://images.pokemontcg.io/sm1/123.png",
            "https://images.pokemontcg.io/sm1/3.png",
            "https://images.pokemontcg.io/sm35/65.png",
            "https://images.pokemontcg.io/sm35/20.png",
            "https://images.pokemontcg.io/sm3/53.png",
            "https://images.pokemontcg.io/sm4/69.png",
            "https://images.pokemontcg.io/sm4/30.png",
            "https://images.pokemontcg.io/sm1/117.png",
            "https://images.pokemontcg.io/sm4/55.png",
            "https://images.pokemontcg.io/sm4/94.png",
            "https://images.pokemontcg.io/sm3/35.png",
            "https://images.pokemontcg.io/sm3/21.png",
            "https://images.pokemontcg.io/sm2/60.png",
            "https://images.pokemontcg.io/sm1/47.png",
            "https://images.pokemontcg.io/sm2/115.png",
            "https://images.pokemontcg.io/sm1/128.png",
            "https://images.pokemontcg.io/sm35/43.png",
            "https://images.pokemontcg.io/sm1/79.png",
            "https://images.pokemontcg.io/sm4/33.png",
            "https://images.pokemontcg.io/sm35/25.png",
            "https://images.pokemontcg.io/sm1/24.png",
            "https://images.pokemontcg.io/sm2/17.png",
            "https://images.pokemontcg.io/sm2/139.png",
            "https://images.pokemontcg.io/sm1/89.png",
            "https://images.pokemontcg.io/sm2/7.png",
            "https://images.pokemontcg.io/sm3/23.png",
            "https://images.pokemontcg.io/sm1/4.png",
            "https://images.pokemontcg.io/sm35/52.png",
            "https://images.pokemontcg.io/sm4/86.png",
            "https://images.pokemontcg.io/sm4/43.png",
            "https://images.pokemontcg.io/sm4/14.png",
            "https://images.pokemontcg.io/sm3/102.png",
            "https://images.pokemontcg.io/sm3/40.png",
            "https://images.pokemontcg.io/sm4/105.png",
            "https://images.pokemontcg.io/sm1/36.png",
            "https://images.pokemontcg.io/sm1/48.png",
            "https://images.pokemontcg.io/sm3/75.png",
            "https://images.pokemontcg.io/sm3/139.png",
            "https://images.pokemontcg.io/sm1/42.png",
            "https://images.pokemontcg.io/sm3/44.png",
            "https://images.pokemontcg.io/sm4/37.png",
            "https://images.pokemontcg.io/sm1/78.png",
            "https://images.pokemontcg.io/sm2/105.png",
            "https://images.pokemontcg.io/sm3/129.png",
            "https://images.pokemontcg.io/sm2/141.png",
            "https://images.pokemontcg.io/sm35/14.png",
            "https://images.pokemontcg.io/sm2/92.png",
            "https://images.pokemontcg.io/sm4/18.png",
            "https://images.pokemontcg.io/sm3/81.png",
            "https://images.pokemontcg.io/sm3/51.png",
            "https://images.pokemontcg.io/sm2/8.png",
            "https://images.pokemontcg.io/sm2/96.png",
            "https://images.pokemontcg.io/sm4/64.png",
            "https://images.pokemontcg.io/sm35/5.png",
            "https://images.pokemontcg.io/sm2/37.png",
            "https://images.pokemontcg.io/sm3/8.png",
            "https://images.pokemontcg.io/sm2/109.png",
            "https://images.pokemontcg.io/sm3/133.png",
            "https://images.pokemontcg.io/sm4/92.png",
            "https://images.pokemontcg.io/sm4/101.png",
            "https://images.pokemontcg.io/sm3/145.png",
            "https://images.pokemontcg.io/sm4/46.png",
            "https://images.pokemontcg.io/sm3/28.png",
            "https://images.pokemontcg.io/sm1/32.png",
            "https://images.pokemontcg.io/sm4/9.png",
            "https://images.pokemontcg.io/sm35/48.png",
            "https://images.pokemontcg.io/sm35/63.png",
            "https://images.pokemontcg.io/sm4/35.png",
            "https://images.pokemontcg.io/sm35/11.png",
            "https://images.pokemontcg.io/sm2/144.png",
            "https://images.pokemontcg.io/sm1/64.png",
            "https://images.pokemontcg.io/sm3/60.png",
            "https://images.pokemontcg.io/sm35/13.png",
            "https://images.pokemontcg.io/sm3/77.png",
            "https://images.pokemontcg.io/sm3/45.png",
            "https://images.pokemontcg.io/sm3/131.png",
            "https://images.pokemontcg.io/sm1/148.png",
            "https://images.pokemontcg.io/sm1/60.png",
            "https://images.pokemontcg.io/sm3/78.png",
            "https://images.pokemontcg.io/sm2/77.png",
            "https://images.pokemontcg.io/sm35/9.png",
            "https://images.pokemontcg.io/sm3/117.png",
            "https://images.pokemontcg.io/sm1/87.png",
            "https://images.pokemontcg.io/sm4/42.png",
            "https://images.pokemontcg.io/sm1/61.png",
            "https://images.pokemontcg.io/sm2/50.png",
            "https://images.pokemontcg.io/sm1/6.png",
            "https://images.pokemontcg.io/sm35/74.png",
            "https://images.pokemontcg.io/sm4/26.png",
            "https://images.pokemontcg.io/sm2/85.png",
            "https://images.pokemontcg.io/sm2/82.png",
            "https://images.pokemontcg.io/sm2/34.png",
            "https://images.pokemontcg.io/sm4/13.png",
            "https://images.pokemontcg.io/sm2/19.png",
            "https://images.pokemontcg.io/sm1/44.png",
            "https://images.pokemontcg.io/sm35/24.png",
            "https://images.pokemontcg.io/sm1/84.png",
            "https://images.pokemontcg.io/sm4/53.png",
            "https://images.pokemontcg.io/sm4/62.png",
            "https://images.pokemontcg.io/sm2/74.png",
            "https://images.pokemontcg.io/sm2/100.png",
            "https://images.pokemontcg.io/sm2/103.png",
            "https://images.pokemontcg.io/sm4/83.png",
            "https://images.pokemontcg.io/sm3/73.png",
            "https://images.pokemontcg.io/sm2/106.png",
            "https://images.pokemontcg.io/sm3/96.png",
            "https://images.pokemontcg.io/sm1/104.png",
            "https://images.pokemontcg.io/sm2/133.png",
            "https://images.pokemontcg.io/sm2/75.png",
            "https://images.pokemontcg.io/sm35/32.png",
            "https://images.pokemontcg.io/sm3/9.png",
            "https://images.pokemontcg.io/sm1/81.png",
            "https://images.pokemontcg.io/sm2/25.png",
            "https://images.pokemontcg.io/sm1/31.png",
            "https://images.pokemontcg.io/sm1/129.png",
            "https://images.pokemontcg.io/sm35/33.png",
            "https://images.pokemontcg.io/sm35/59.png",
            "https://images.pokemontcg.io/sm1/21.png",
            "https://images.pokemontcg.io/sm4/71.png",
            "https://images.pokemontcg.io/sm1/126.png",
            "https://images.pokemontcg.io/sm2/54.png",
            "https://images.pokemontcg.io/sm1/114.png",
            "https://images.pokemontcg.io/sm2/72.png",
            "https://images.pokemontcg.io/sm2/88.png",
            "https://images.pokemontcg.io/sm3/30.png",
            "https://images.pokemontcg.io/sm2/56.png",
            "https://images.pokemontcg.io/sm4/40.png",
            "https://images.pokemontcg.io/sm4/108.png",
            "https://images.pokemontcg.io/sm2/65.png",
            "https://images.pokemontcg.io/sm35/71.png",
            "https://images.pokemontcg.io/sm1/82.png",
            "https://images.pokemontcg.io/sm3/137.png",
            "https://images.pokemontcg.io/sm4/8.png",
            "https://images.pokemontcg.io/sm1/105.png",
            "https://images.pokemontcg.io/sm2/33.png",
            "https://images.pokemontcg.io/sm1/56.png",
            "https://images.pokemontcg.io/sm2/46.png",
            "https://images.pokemontcg.io/sm2/3.png",
            "https://images.pokemontcg.io/sm1/125.png",
            "https://images.pokemontcg.io/sm4/52.png",
            "https://images.pokemontcg.io/sm1/93.png",
            "https://images.pokemontcg.io/sm1/106.png",
            "https://images.pokemontcg.io/sm3/80.png",
            "https://images.pokemontcg.io/sm3/106.png",
            "https://images.pokemontcg.io/sm4/5.png",
            "https://images.pokemontcg.io/sm4/97.png",
            "https://images.pokemontcg.io/sm2/64.png",
            "https://images.pokemontcg.io/sm2/98.png",
            "https://images.pokemontcg.io/sm35/6.png",
            "https://images.pokemontcg.io/sm4/24.png",
            "https://images.pokemontcg.io/sm1/91.png",
            "https://images.pokemontcg.io/sm2/58.png",
            "https://images.pokemontcg.io/sm3/5.png",
            "https://images.pokemontcg.io/sm1/41.png",
            "https://images.pokemontcg.io/sm1/72.png",
            "https://images.pokemontcg.io/sm2/83.png",
            "https://images.pokemontcg.io/sm1/62.png",
            "https://images.pokemontcg.io/sm1/70.png",
            "https://images.pokemontcg.io/sm4/74.png",
            "https://images.pokemontcg.io/sm2/101.png",
            "https://images.pokemontcg.io/sm4/98.png",
            "https://images.pokemontcg.io/sm3/55.png",
            "https://images.pokemontcg.io/sm3/142.png",
            "https://images.pokemontcg.io/sm1/113.png",
            "https://images.pokemontcg.io/sm1/135.png",
            "https://images.pokemontcg.io/sm2/42.png",
            "https://images.pokemontcg.io/sm35/70.png",
            "https://images.pokemontcg.io/sm35/36.png",
            "https://images.pokemontcg.io/sm35/2.png",
            "https://images.pokemontcg.io/sm3/108.png",
            "https://images.pokemontcg.io/sm4/73.png",
            "https://images.pokemontcg.io/sm35/15.png",
            "https://images.pokemontcg.io/sm4/54.png",
            "https://images.pokemontcg.io/sm1/137.png",
            "https://images.pokemontcg.io/sm1/27.png",
            "https://images.pokemontcg.io/sm4/88.png",
            "https://images.pokemontcg.io/sm35/1.png",
            "https://images.pokemontcg.io/sm35/7.png",
            "https://images.pokemontcg.io/sm1/116.png",
            "https://images.pokemontcg.io/sm3/134.png",
            "https://images.pokemontcg.io/sm4/20.png",
            "https://images.pokemontcg.io/sm3/125.png",
            "https://images.pokemontcg.io/sm2/61.png",
            "https://images.pokemontcg.io/sm4/61.png",
            "https://images.pokemontcg.io/sm2/87.png",
            "https://images.pokemontcg.io/sm3/140.png",
            "https://images.pokemontcg.io/sm35/54.png",
            "https://images.pokemontcg.io/sm1/139.png",
            "https://images.pokemontcg.io/sm2/112.png",
            "https://images.pokemontcg.io/sm3/1.png",
            "https://images.pokemontcg.io/sm1/37.png",
            "https://images.pokemontcg.io/sm4/15.png",
            "https://images.pokemontcg.io/sm2/81.png",
            "https://images.pokemontcg.io/sm2/143.png",
            "https://images.pokemontcg.io/sm1/69.png",
            "https://images.pokemontcg.io/sm35/51.png",
            "https://images.pokemontcg.io/sm4/49.png",
            "https://images.pokemontcg.io/sm3/32.png",
            "https://images.pokemontcg.io/sm4/47.png",
            "https://images.pokemontcg.io/sm3/111.png",
            "https://images.pokemontcg.io/sm1/40.png",
            "https://images.pokemontcg.io/sm4/21.png",
            "https://images.pokemontcg.io/sm3/19.png",
            "https://images.pokemontcg.io/sm4/76.png",
            "https://images.pokemontcg.io/sm2/131.png",
            "https://images.pokemontcg.io/sm3/109.png",
            "https://images.pokemontcg.io/sm1/111.png",
            "https://images.pokemontcg.io/sm4/10.png",
            "https://images.pokemontcg.io/sm2/84.png",
            "https://images.pokemontcg.io/sm1/90.png",
            "https://images.pokemontcg.io/sm2/68.png",
            "https://images.pokemontcg.io/sm2/119.png",
            "https://images.pokemontcg.io/sm3/49.png",
            "https://images.pokemontcg.io/sm3/72.png",
            "https://images.pokemontcg.io/sm3/91.png",
            "https://images.pokemontcg.io/sm2/79.png",
            "https://images.pokemontcg.io/sm3/86.png",
            "https://images.pokemontcg.io/sm4/12.png",
            "https://images.pokemontcg.io/sm2/23.png",
            "https://images.pokemontcg.io/sm3/43.png",
            "https://images.pokemontcg.io/sm1/12.png",
            "https://images.pokemontcg.io/sm2/113.png",
            "https://images.pokemontcg.io/sm3/41.png",
            "https://images.pokemontcg.io/sm2/121.png",
            "https://images.pokemontcg.io/sm3/141.png",
            "https://images.pokemontcg.io/sm35/44.png",
            "https://images.pokemontcg.io/sm3/18.png",
            "https://images.pokemontcg.io/sm3/47.png",
            "https://images.pokemontcg.io/sm35/31.png",
            "https://images.pokemontcg.io/sm1/138.png",
            "https://images.pokemontcg.io/sm1/97.png",
            "https://images.pokemontcg.io/sm35/23.png",
            "https://images.pokemontcg.io/sm4/34.png",
            "https://images.pokemontcg.io/sm35/69.png",
            "https://images.pokemontcg.io/sm3/12.png",
            "https://images.pokemontcg.io/sm3/37.png",
            "https://images.pokemontcg.io/sm35/78.png"
    )
}