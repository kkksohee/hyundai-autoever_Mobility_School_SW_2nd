// import tailwindcss from "@tailwindcss/postcss";
// export default {
//   plugins: {
//     tailwindcss(),
//     // tailwindcss: {},
//     // "@tailwindcss/postcss": {},
//     autoprefixer: {},
//   },
// };

import tailwindcssPostcss from "@tailwindcss/postcss";

export default {
  plugins: [tailwindcssPostcss()],
};
