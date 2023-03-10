const pessoa = {
  nome: 'Ada',
  idade: 36,
  profissao: 'matemática'
};

const descrevePessoa = ({ nome, idade, profissao }) => `Esta é ${nome}, tem ${idade} anos e é ${profissao}.`

console.log(descrevePessoa(pessoa))