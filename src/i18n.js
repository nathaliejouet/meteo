import { createI18n } from "vue-i18n";

export const i18n = createI18n({
  legacy: false,
  locale: "fr",
  globalInjection: true,
  messages: {
    en: {
      feelsLikeTempTitle: "Feels Like",
      errors: {
        badRequest: "Please enter a city",
        notFound: "The city you are looking for does not exist",
        otherError: "An error occurred while searching",
      },
    },
    fr: {
      feelsLikeTempTitle: "Température ressentie",
      errors: {
        badRequest: "Merci de saisir une ville",
        notFound: "La ville recherchée n'existe pas",
        otherError: "Une erreur s'est produite lors de la recherche",
      },
    },
  },
});
